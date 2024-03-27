package com.example.Crud.controller;

import com.example.Crud.dto.request.StudentRequest;
import com.example.Crud.dto.response.StudentResponse;
import com.example.Crud.serviceImpl.StudentServiceImpl;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl service;

    @PostMapping("/save")
    public ResponseEntity<StudentResponse> save(@RequestBody StudentRequest studentRequest){

        StudentResponse savedResponse = service.save(studentRequest);
        return new ResponseEntity<>(savedResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentResponse>> getAll(){
        List<StudentResponse> studentResponseList = service.getAll();
        return new ResponseEntity<>(studentResponseList,HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<StudentResponse> findById(@PathVariable Integer id){
        StudentResponse studentResponse = service.findById(id);
        return new ResponseEntity<>(studentResponse,HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public String deleteStudent(Integer id){
        service.deleteStudentById(id);
        return "Student Record Deleted Successfully ...";
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<StudentResponse> updateById(@RequestBody StudentRequest studentRequest,@PathVariable Integer id){

        StudentResponse studentResponse = service.updateById(studentRequest,id);
        return new ResponseEntity<>(studentResponse,HttpStatus.OK);
    }



}
