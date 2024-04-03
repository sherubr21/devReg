package com.Athang.Athang.controller;

import com.Athang.Athang.service.SmtpGmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

@Controller
public class EmailTestController {
     SmtpGmailSenderService senderService;

  // @Autowired
  /*  public EmailTestController(SmtpGmailSenderService senderService) {
        this.senderService = senderService;
    }*/

    //@EventListener(ApplicationReadyEvent.class)
    public  void sendMail(){
        senderService.sendEmail("sherubr@yahoo.com","This is subject","This is email body");
    }

}
