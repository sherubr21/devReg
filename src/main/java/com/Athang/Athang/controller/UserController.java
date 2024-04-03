package com.Athang.Athang.controller;

import com.Athang.Athang.dto.LoginDto;
import com.Athang.Athang.message.LoginMesage;
import com.Athang.Athang.model.LkpUserType;
import com.Athang.Athang.model.Users;
import com.Athang.Athang.repository.LkpUserTypeRespository;
import com.Athang.Athang.service.SmtpGmailSenderService;
import com.Athang.Athang.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private LkpUserTypeRespository lkpUserTypeRespository;
    @PostMapping
    public ResponseEntity<Users> createUserWithUserType(@RequestParam Integer userTypeId,@RequestBody Users user) {
        Optional<LkpUserType> userType = lkpUserTypeRespository.findById(userTypeId);
        if (userType.isPresent()) {
            Users createdUser = usersService.createUserWithUserType(user, userType.get());
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /*Users adduser(@RequestBody Users users){
        return usersService.adduser(users);

    }*/

    @GetMapping("/getuser")
    List<Users> getUser(){
        //EmailTestController.sendMail();
      //  senderService.sendEmail("sherubr@yahoo.com","This is subject","This is email body");
        return usersService.getUsers();

    }
    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        LoginMesage loginMesage=usersService.loginUser(loginDto);
        return ResponseEntity.ok(loginMesage);

    }
  /*  @PutMapping("/update/{id}")
    ResponseEntity<Users> upDateUser(@PathVariable Integer id,@RequestBody Users users){
        Users updUser=usersService.updateUsers(id,users);
        if(updUser !=null){
            return ResponseEntity.ok(users);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    void deleteuser(@PathVariable Integer id){
        usersService.deleteUser(id);
    }*/

}
