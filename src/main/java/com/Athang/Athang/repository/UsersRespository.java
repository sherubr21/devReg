package com.Athang.Athang.repository;

import com.Athang.Athang.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRespository extends JpaRepository<Users,Integer> {
    Optional<Users> findOneByEmailAndPassword(String email,String password);
    Users findByEmail(String email);
}
