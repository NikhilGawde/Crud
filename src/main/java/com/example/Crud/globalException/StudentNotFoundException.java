package com.example.Crud.globalException;

public class StudentNotFoundException extends RuntimeException{
    Integer id;
    public StudentNotFoundException(Integer id){
        super("Student Not Found With Id : "+id);
        this.id=id;
    }
}
