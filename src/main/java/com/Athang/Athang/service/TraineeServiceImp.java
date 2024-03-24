// TraineeServiceImp.java
package com.Athang.Athang.service;

import com.Athang.Athang.model.Trainee;
import com.Athang.Athang.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeServiceImp implements TraineeService {

    @Autowired
    private TraineeRepository traineeRepository;

    @Override
    public Trainee saveTrainee(Trainee trainee) {
        return traineeRepository.save(trainee);
    }

    @Override
    public List<Trainee> getTrainee() {
        return traineeRepository.findAll();
    }

    @Override
    public Trainee updateTrainee(Integer id, Trainee trainee) {
        // Implementation for updating trainee
        return null;
    }
}
