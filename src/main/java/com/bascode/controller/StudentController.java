package com.bascode.controller;

import com.bascode.model.Student;
import com.bascode.service.StudentService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/student")
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //building save student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.createStudent(student), HttpStatusCode.valueOf(201));
    }

    //build get all student
    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    //build find student by id
    @GetMapping("{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId") long studentId){
        return  new ResponseEntity<Student>(studentService.getStudentById(studentId), HttpStatusCode.valueOf(200));
    }

    //build update student
    @PutMapping("{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable("studentId") long studentId,
                                                 @RequestBody Student student){
        return new ResponseEntity<Student>(studentService.updateStudent(student, studentId),
                HttpStatusCode.valueOf(200));
    }

    //build delete student by id
    @DeleteMapping("{studentId}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("studentId") long studentId){
       studentService.deleteStudentById(studentId);
       return new ResponseEntity<String>("student deleted from Database...", HttpStatusCode.valueOf(200));
    }


}
