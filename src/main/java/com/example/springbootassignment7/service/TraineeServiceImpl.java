package com.example.springbootassignment7.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootassignment7.entities.Trainee;
import com.example.springbootassignment7.repo.ITraineeRepo;


@Service
public class TraineeServiceImpl implements ITraineeService {
	
	@Autowired
    private ITraineeRepo repo;
	
	  @Override
	    public Trainee addTrainee(Trainee t) {
	        return repo.save(t);
	    }

	  @Override
	  public boolean deleteTrainee(int id) {
	      if (repo.existsById(id)) {
	          repo.deleteById(id);
	          return true;
	      }
	      return false;
	  }

	    @Override
	    public Trainee updateTrainee(int id, Trainee t) {
	        Trainee existing = repo.findById(id).orElse(null);
	        if (existing != null) {
	            existing.setTraineeName(t.getTraineeName());
	            existing.setTraineeDomain(t.getTraineeDomain());
	            existing.setTraineeLocation(t.getTraineeLocation());
	            return repo.save(existing);
	        }
	        return null;
	    }

	   

	    @Override
	    public List<Trainee> getAllTrainees() {
	        return repo.findAll();
	    }

		@Override
		public Optional<Trainee> getTrainee(int id) {
			return repo.findById(id);
			
		}

		@Override
		public Optional<Trainee> findBytraineeName(String name) {
			return repo.findBytraineeName(name);
		
		}
	
	

}



















