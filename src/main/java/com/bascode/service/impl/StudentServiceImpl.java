package com.bascode.service.impl;

import com.bascode.exception.ResourceNotFoundException;
import com.bascode.model.Student;
import com.bascode.repository.StudentRepository;
import com.bascode.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long studentId) {
     /*  Optional <Student> student = studentRepository.findById(studentId);
       if(student.isPresent()){
          return studentRepository.get();
       }else {
           throw new ResourceNotFoundException("Student", "studentId", studentId);
       } */
        return studentRepository.findById(studentId).orElseThrow(() ->
                new ResourceNotFoundException("Student", "studentId", studentId));
    }

    @Override
    public Student updateStudent(Student student, long studentId) {
        Student student1 = studentRepository.findById(studentId).orElseThrow(()
                -> new ResourceNotFoundException("Student", "studentId", studentId) );
        student1.setStudentFirstName(student.getStudentFirstName());
        student1.setStudentLastName(student.getStudentLastName());
        student1.setStudentEmail(student.getStudentEmail());
        studentRepository.save(student1);
        return student1;
    }

    @Override
    public void deleteStudentById(long studentId) {
        studentRepository.findById(studentId).orElseThrow(() ->
                new ResourceNotFoundException("Student", "studentId", studentId));
        studentRepository.deleteById(studentId);
    }

}


























