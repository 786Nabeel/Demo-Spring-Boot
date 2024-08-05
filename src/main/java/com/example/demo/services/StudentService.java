package com.example.demo.services;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id).get();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}