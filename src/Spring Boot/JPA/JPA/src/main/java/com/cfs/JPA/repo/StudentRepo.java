package com.cfs.JPA.repo;

import com.cfs.JPA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
    // JpaRepositry ke jagah CrudRepository bhi laga skte hai par mujhe @Repository lagana pdega, aur jo humne JpaRepositry use kiya hai ye advance hai  eske andar pagingnation, search , sorting bhi aata hai
    // but CrudRepository kafi basic hai
    // JpaRepositry ke case mein @Repository lagane ke jarurat nhi hai par @Repository laga aachi practice hoti hai
}
