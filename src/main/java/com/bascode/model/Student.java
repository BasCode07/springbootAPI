package com.bascode.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(updatable = false)
    private  long studentId;

    @Column(name = "first_name", nullable = false, length = 10)
    private String studentFirstName;

    @Column(name = "last_name", nullable = false, length = 10)
    private String studentLastName;

    @Column(name = "email", nullable = false, length = 30, unique = true)
    private String studentEmail;


    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
}
