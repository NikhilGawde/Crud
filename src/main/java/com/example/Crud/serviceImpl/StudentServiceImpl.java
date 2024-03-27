package com.example.Crud.serviceImpl;

import com.example.Crud.dto.request.StudentRequest;
import com.example.Crud.dto.response.StudentResponse;
import com.example.Crud.entity.Student;
import com.example.Crud.globalException.StudentNotFoundException;
import com.example.Crud.repository.StudentRepository;
import com.example.Crud.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentResponse save(StudentRequest studentRequest) {
        Student student = this.modelMapper.map(studentRequest, Student.class);
        student = this.repository.save(student);

        return this.modelMapper.map(student,StudentResponse.class);
    }

    @Override
    public List<StudentResponse> getAll() {

        List<Student> studentList = (this.repository.findAll());

        return studentList.stream()
                .map(student -> modelMapper.map(student, StudentResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse findById(Integer id) {

       Optional<Student> student = this.repository.findById(id);

       if(student.isPresent())
           return this.modelMapper.map(student,StudentResponse.class);
       else
           throw new StudentNotFoundException(id);
    }

    @Override
    public void deleteStudentById(Integer id) {

//        Optional<Student> student = repository.findById(id);
//        if(student.isPresent()){
//            repository.deleteById(id);
//        }
//        else {
//            throw new StudentNotFoundException(id);
//        }

        Student student = repository.findById(id).orElseThrow(()->new StudentNotFoundException(id));
        this.repository.delete(student);
    }

    @Override
    public StudentResponse updateById(StudentRequest studentRequest, Integer id) {
        Student student = this.modelMapper.map(studentRequest,Student.class);
        student = this.repository.findById(id).orElseThrow(()->new StudentNotFoundException(id));
        student.setName(studentRequest.getName());
        student.setNumber(studentRequest.getNumber());
        student.setCity(studentRequest.getCity());

        student = this.repository.save(student);

        return this.modelMapper.map(student,StudentResponse.class);

    }

}
