package com.example.demo.webcontroller;

import com.example.demo.entities.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @CrossOrigin(origins = "http://127.0.0.1:5500") // Replace with your frontend URL
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudent/{id}")
    public Object getStudentById(@PathVariable String id) {
        try{
            Student student = studentService.getStudentById(id);
            if(student == null){
                return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
            }
            return student;
        }
        catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }


    }


    @GetMapping("/getStudent")
    public Object getSingleStudent(@RequestParam String id) {
        try{

            Student student = studentService.getStudentById(id);
            if(student == null){
                return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
            }
            return student;
        }
        catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
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


    @PostMapping("/saveFormStudent")
    public ResponseEntity<String> saveFormStudent(@ModelAttribute Student student) {
        try {
            studentService.saveStudent(student);
            return new ResponseEntity<>("Student saved successfully", HttpStatus.OK);
        } catch (Exception e) {
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

    @PutMapping("/updateStudent")
    public ResponseEntity<String> updateStudent(@RequestBody Student student) {
      try{
          if(studentService.getStudentById(student.getId()) == null){
              return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
          }

          studentService.saveStudent(student);
          return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
      }
      catch(Exception e){
          System.out.println(e.getLocalizedMessage());
          return new ResponseEntity<>("Student not updated", HttpStatus.BAD_REQUEST);
      }
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
      try{
          if(studentService.getStudentById(id) == null){
              return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
          }

          studentService.deleteStudent(id);
          return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
      }
      catch(Exception e){
          System.out.println(e.getLocalizedMessage());
          return new ResponseEntity<>("Student not deleted", HttpStatus.BAD_REQUEST);
      }
    }





}
