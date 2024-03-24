package com.Athang.Athang.repository;

import com.Athang.Athang.model.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TraineeRepository extends JpaRepository<Trainee,Integer> {
}
