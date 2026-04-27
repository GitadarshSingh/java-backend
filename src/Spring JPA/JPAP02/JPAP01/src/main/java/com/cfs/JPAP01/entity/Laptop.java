package com.cfs.JPAP01.entity;

import jakarta.persistence.*;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    @OneToOne
    @JoinColumn(name="student_id",unique=true) // laptop foreign key hai, jidhar foreign key udar @JoinColumn lageag
    // Student ko owining class mann rha hu esliye laptop foreign entity hai
    private Student student;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
