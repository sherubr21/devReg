package com.Athang.Athang.controller;

import com.Athang.Athang.model.LkpCourse;
import com.Athang.Athang.service.LkpCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin

public class LkpCourseContoller {
    @Autowired
    private LkpCourseService lkpCourseService;
    @PostMapping

    public LkpCourse add(@RequestBody LkpCourse lkpCourse){
        return lkpCourseService.saveCourse(lkpCourse);

    }
    @GetMapping("/getcourse")
    List<LkpCourse> getCourse(){
        return lkpCourseService.getCourse();
    }
    @PutMapping("/update/{id}")
    ResponseEntity<LkpCourse> update(@PathVariable Integer id, LkpCourse lkpCourse){
        LkpCourse updCourse=lkpCourseService.updateCourse(id,lkpCourse);
        if(updCourse !=null)
        {
            return ResponseEntity.ok(updCourse);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Integer id){
        lkpCourseService.deleteCourse(id);
    }
}
