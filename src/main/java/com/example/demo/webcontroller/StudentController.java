package com.example.demo.webcontroller;

import com.example.demo.entities.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
      try{
          studentService.saveStudent(student);
          return new ResponseEntity<>("Student saved successfully", HttpStatus.OK);
      }
      catch(Exception e){
          System.out.println(e.getLocalizedMessage());
       return new ResponseEntity<>("Student not saved", HttpStatus.BAD_REQUEST);
      }
    }

    @PostMapping("/saveStudents")
    public ResponseEntity<String> saveStudents(@RequestBody List<Student> students) {
      try{
          for (Student student : students) {
              studentService.saveStudent(student);
          }
          return new ResponseEntity<>("Students saved successfully", HttpStatus.OK);

      }
      catch (Exception e){
          System.out.println(e.getLocalizedMessage());
          return new ResponseEntity<>("Students not saved", HttpStatus.BAD_REQUEST);
      }

    }





}
