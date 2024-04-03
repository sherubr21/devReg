// TraineeService.java
package com.Athang.Athang.service;

import com.Athang.Athang.model.Trainee;

import java.util.List;

public interface TraineeService {
    Trainee saveTrainee(Trainee trainee);

    List<Trainee> getTrainee();

    Trainee updateTrainee(Integer id, Trainee trainee);

    void deleteT(Integer id);

}
