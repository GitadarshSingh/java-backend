package org.example;

public class Student {
    public Course course; // Object


    //Constructor Injection
    public Student(){
    }



    public Student(Course course) {
        this.course = course;
    }

    //Error : Because need Dependency Injection using setter method
    //Setter Injection

    public void setCourse(Course course) {
        this.course = course;
    }

    public void study(){
        int start = course.enroll();
        if(start>=1){
            System.out.println("Journey Started...");
        }
        else{
            System.out.println("Invalid Enrollment...");
        }
    }

}
