package com.cfs.JPAP01.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //---------------------------------------------------------------------------

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL) //cascade = CascadeType.ALL: ensure voilation of ACID properties
    private Laptop laptop;

    //----------------------------------------------------------------------------

    @ManyToOne(fetch = FetchType.LAZY) //fetch = FetchType.LAZY : beacuse performance fast karne keliye
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    //-----------------------------------------------------------------------------

    @ManyToMany
    @JoinTable(
            name="student_course",
            joinColumns = @JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name="student_id")
    )
    @JsonIgnoreProperties("student")// network par jane se ignore kar rha hu
    private Set<Course> course = new HashSet<>();

    //---------------------------------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
}
