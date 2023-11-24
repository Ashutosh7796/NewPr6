package com.example.Project06.Repository;

import com.example.Project06.Entity.Blogs;
import com.example.Project06.Entity.HrCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HrCallRepo extends JpaRepository<HrCall,Integer> {
    List<HrCall> findByuserId(Integer userId);
}
