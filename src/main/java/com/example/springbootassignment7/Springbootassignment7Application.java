package com.example.springbootassignment7;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springbootassignment7.entities.Trainee;
import com.example.springbootassignment7.service.ITraineeService;

@SpringBootApplication
public class Springbootassignment7Application  implements CommandLineRunner {
	
	@Autowired
	ITraineeService service; 

	public static void main(String[] args) {
		System.out.println("Application Context is Loaded!!!");
		SpringApplication.run(Springbootassignment7Application.class, args);
	}

	@Override
    public void run(String... args) throws Exception {

//		 Scanner sc = new Scanner(System.in);
//
//	        while (true) {
//	            System.out.println("\nPick your operation:");
//	            System.out.println("1. Add a Trainee");
//	            System.out.println("2. Delete a Trainee");
//	            System.out.println("3. Modify a Trainee");
//	            System.out.println("4. Retrieve a Trainee by id");
//	            System.out.println("5. Retrieve all Trainees");
//	            System.out.println("6. Exit");
//
//	            int choice = sc.nextInt();
//
//	            switch (choice) {
//
//	            case 1:
//	                Trainee t = new Trainee();
//	                System.out.print("Enter Name: ");
//	                t.setTraineeName(sc.next());
//
//	                System.out.print("Enter Domain: ");
//	                t.setTraineeDomain(sc.next());
//
//	                System.out.print("Enter Location: ");
//	                t.setTraineeLocation(sc.next());
//
//	                Trainee saved = service.addTrainee(t);
//	                System.out.println("Added with ID: " + saved.getTraineeId());
//	                break;
//
//	            case 2:
//	                System.out.print("Enter ID to delete: ");
//	                int id = sc.nextInt();
//	                service.deleteTrainee(id);
//	                System.out.println("Deleted successfully");
//	                break;
//
//	            case 3:
//	                System.out.print("Enter ID to update: ");
//	                int uid = sc.nextInt();
//
//	                Trainee nt = new Trainee();
//	                System.out.print("Enter New Name: ");
//	                nt.setTraineeName(sc.next());
//
//	                System.out.print("Enter New Domain: ");
//	                nt.setTraineeDomain(sc.next());
//
//	                System.out.print("Enter New Location: ");
//	                nt.setTraineeLocation(sc.next());
//
//	                Trainee updated = service.updateTrainee(uid, nt);
//	                if (updated != null)
//	                    System.out.println("Updated successfully");
//	                else
//	                    System.out.println("Trainee not found");
//	                break;
//
//	            case 4:
//	                System.out.print("Enter ID: ");
//	                int rid = sc.nextInt();
//
//	                Optional<Trainee> tr = service.getTrainee(rid);
//
//	                if (tr.isPresent()) {
//	                    System.out.println(tr.get().getTraineeName() + " " + tr.get().getTraineeDomain());
//	                } else {
//	                    System.out.println("Not found");
//	                }
//	                break;
//
//	            case 5:
//	                List<Trainee> list = service.getAllTrainees();
//	                for (Trainee tt : list) {
//	                    System.out.println(tt.getTraineeId() + " " + tt.getTraineeName());
//	                }
//	                break;
//
//	            case 6:
//	                System.exit(0);
//
//	            default:
//	                System.out.println("Invalid choice");
//    }
//	
//	
//
//	        	}
	}
}