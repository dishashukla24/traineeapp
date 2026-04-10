package com.example.springbootassignment7.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootassignment7.entities.Trainee;


@Repository
public interface ITraineeRepo extends JpaRepository<Trainee, Integer>{
	
	Optional<Trainee> findBytraineeName(String name);

}
