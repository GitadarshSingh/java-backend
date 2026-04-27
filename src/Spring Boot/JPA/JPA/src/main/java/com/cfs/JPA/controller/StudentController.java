package com.cfs.JPA.controller;

import com.cfs.JPA.entity.Student;
import com.cfs.JPA.repo.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepo studentRepo;//
    //agar single variable hai, aur agr final nhi bnaunaga tho ese @Autowire kr skta hu
    // agar humne esa final banaya hai tho, constuctor bana padega

    public StudentController(StudentRepo studentRepo) { // <--constructor dependency injection
        this.studentRepo = studentRepo;
    }
    //Questuion : Agar aap ki class mein ek he variable hai studentRepo aur app constuctor use kar rhe ho dependency inject krne ke liye, tho kya construtcor ke upar @Autowire lagana jaroori hai?
    // Ans : No,  agar ek he variable hai

    //let's create api

    @PostMapping
    public Student createStudent(@RequestBody Student student)
    {
        return studentRepo.save(student);
    }

    @GetMapping
    public List<Student> getAllStudent()
    {
        return studentRepo.findAll();
    }

//    @PutMapping("/{id}")
//    public Student updateStudent(@PathVariable Long id){ //student ko update krne ke liye 'id' chaiye
//                   Method 1
//    }


    //Method 2
    @PutMapping
    public Student updateStudent(@RequestParam Long id,@RequestBody Student student)
    {
        Student s = studentRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Student not found"));

        s.setName(student.getName());
        s.setEmail(student.getEmail());
        return studentRepo.save(s);
    }


    @PatchMapping
    public Student patchStudent(@RequestParam Long id,@RequestParam String email,@RequestParam String name)
    {
        Student s = studentRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Student not found"));

        s.setEmail(email);
        s.setName(name);
        return s;
    }

}


