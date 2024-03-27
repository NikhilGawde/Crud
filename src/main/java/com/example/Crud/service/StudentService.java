package com.example.Crud.service;

import com.example.Crud.dto.request.StudentRequest;
import com.example.Crud.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {

    public StudentResponse save(StudentRequest studentRequest);

    public List<StudentResponse> getAll();

    public StudentResponse findById(Integer id);

    public void deleteStudentById(Integer id);

    public StudentResponse updateById(StudentRequest studentRequest,Integer id);




}
