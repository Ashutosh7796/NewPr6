package com.example.Project06.Repository;

import com.example.Project06.Entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentProfRepo extends JpaRepository <StudentProfile, Integer> {

}
