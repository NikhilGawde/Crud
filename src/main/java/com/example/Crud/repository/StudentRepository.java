package com.example.Crud.repository;

import com.example.Crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {


}
