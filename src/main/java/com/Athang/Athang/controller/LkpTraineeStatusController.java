package com.Athang.Athang.controller;

import com.Athang.Athang.model.LkpDoc;
import com.Athang.Athang.model.LkpTraineeStatus;
import com.Athang.Athang.service.LkpTraineeStatusService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lkpTrainee")
@CrossOrigin
public class LkpTraineeStatusController {
    @Autowired
    private LkpTraineeStatusService lkpTraineeStatusService;
    @PostMapping
    LkpTraineeStatus add(@RequestBody LkpTraineeStatus lkpTraineeStatus){
        return lkpTraineeStatusService.save(lkpTraineeStatus);
    }
    @GetMapping("/getall")
    List<LkpTraineeStatus> getall(){
        return lkpTraineeStatusService.getAll();
    }
    @PutMapping("/update/{id}")
    ResponseEntity<LkpTraineeStatus> update(@PathVariable Integer id,@RequestBody LkpTraineeStatus lkpTraineeStatus){

        LkpTraineeStatus lkpTraineeStatus1=lkpTraineeStatusService.update(id,lkpTraineeStatus);
        if(lkpTraineeStatus1 !=null)
        {
            return ResponseEntity.ok(lkpTraineeStatus1);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("delete/{id}")
    void delete(@PathVariable Integer id){
        lkpTraineeStatusService.delete(id);
    }
}
