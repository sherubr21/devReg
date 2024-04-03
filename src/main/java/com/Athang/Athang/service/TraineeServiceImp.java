// TraineeServiceImp.java
package com.Athang.Athang.service;

import com.Athang.Athang.model.Trainee;
import com.Athang.Athang.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        //return traineeRepository.;
        Optional<Trainee> existingTraineeOptional = traineeRepository.findById(id);

        if (existingTraineeOptional.isPresent()) {
            Trainee existingTrainee = existingTraineeOptional.get();
            // Update the existing trainee with the new details
            existingTrainee.setName(trainee.getName());
            existingTrainee.setEmail(trainee.getEmail());
            existingTrainee.setCourse(trainee.getCourse());
            existingTrainee.setDesignation(trainee.getDesignation());
            existingTrainee.setOrganisation(trainee.getOrganisation());

            // Update other fields as needed

            // Save the updated trainee to the repository
            return traineeRepository.save(existingTrainee);
        } else {
            // Handle the case where the trainee with the given ID doesn't exist
            // For example, you can throw an exception or return null
            throw new IllegalArgumentException("Trainee with ID " + id + " not found");
        }
    }

    @Override
    public void deleteT(Integer id) {
         traineeRepository.deleteById(id);
    }
}
