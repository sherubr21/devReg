package com.Athang.Athang.controller;

import com.Athang.Athang.model.LkpCourse;
import com.Athang.Athang.model.LkpDoc;
import com.Athang.Athang.service.LkpDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lkpDoc")
@CrossOrigin
public class LkpDocController {
    @Autowired
    private LkpDocService lkpDocService;
     @PostMapping
    LkpDoc add(@RequestBody LkpDoc lkpDoc){
        return lkpDocService.saveLkpDoc(lkpDoc);
    }
    @GetMapping("/getall")
    List<LkpDoc> getLkpDoc(){
        return lkpDocService.getLkpDoc();
    }
    @PutMapping("/update/{id}")
    ResponseEntity<LkpDoc> updateLkpdoc(@PathVariable Integer id, @RequestBody LkpDoc lkpDoc){
        LkpDoc uplkpdoc=lkpDocService.upDateLkpDoc(id,lkpDoc);
        if(uplkpdoc !=null)
        {
            return ResponseEntity.ok(uplkpdoc);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    void deleteLkpDoc(@PathVariable Integer id){
        lkpDocService.deleteLkpdoc(id);
    }



}
