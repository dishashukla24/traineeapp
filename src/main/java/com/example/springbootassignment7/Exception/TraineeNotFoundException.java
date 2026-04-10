package com.example.springbootassignment7.Exception;

public class TraineeNotFoundException extends RuntimeException{
    public TraineeNotFoundException(){
    super("TraineeNotFound");
    }
}