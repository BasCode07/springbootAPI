package com.bascode.service;

import com.bascode.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
   List<Student> getAllStudent();
   Student getStudentById(long studentId);
   Student updateStudent(Student student, long studentId);

   void deleteStudentById(long studentId);
}
