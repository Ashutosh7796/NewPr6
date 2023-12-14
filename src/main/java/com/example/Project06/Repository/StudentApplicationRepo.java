package com.example.Project06.Repository;

import com.example.Project06.Entity.StudentApplication;
import com.example.Project06.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentApplicationRepo extends JpaRepository<StudentApplication, Integer> {
    boolean existsByUserUserAndJobId(User user, Integer jobId);

    List<StudentApplication> findByUserUser(User user);
    List<StudentApplication> findByJobId(Integer jobId);

}
