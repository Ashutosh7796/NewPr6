package com.example.Project06.Repository;

import com.example.Project06.Entity.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcampRepo extends JpaRepository<Bootcamp,Integer> {
}
