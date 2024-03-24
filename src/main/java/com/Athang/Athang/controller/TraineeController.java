// TraineeController.java
package com.Athang.Athang.controller;

import com.Athang.Athang.model.Trainee;
import com.Athang.Athang.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainee")
@CrossOrigin
public class TraineeController {
    @Autowired
    private TraineeService traineeService;

    @PostMapping("/add")
    public Trainee add(@RequestBody Trainee trainee) {
        return traineeService.saveTrainee(trainee);
    }

    @GetMapping("/getall")
    public List<Trainee> list() {
        return traineeService.getTrainee();
    }
}
