package com.cfs.JPAP01.repo;

import com.cfs.JPAP01.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepo extends JpaRepository<Laptop,Long> {
}
