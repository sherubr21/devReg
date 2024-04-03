package com.Athang.Athang.controller;

import com.Athang.Athang.model.LkpUserType;
import com.Athang.Athang.service.LkpUserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lkpUserType")
@CrossOrigin
public class LkpUserTypeController {
    @Autowired
    private LkpUserTypeService lkpUserTypeService;
    @PostMapping
    LkpUserType addUsertype(@RequestBody LkpUserType lkpUserType){
        return lkpUserTypeService.saveType(lkpUserType);
    }
    @GetMapping("/getall")
    List<LkpUserType> getUserType(){
        return lkpUserTypeService.getType();
    }
    @PutMapping("/update/{id}")
    ResponseEntity<LkpUserType> updateUserType(@PathVariable Integer id,@RequestBody LkpUserType lkpUserType){
        LkpUserType updusrtype=lkpUserTypeService.updateType(id,lkpUserType);
        if(updusrtype !=null){
            return ResponseEntity.ok(updusrtype);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    void deleteUserType(@PathVariable Integer id){
        lkpUserTypeService.deleteType(id);
    }

}
