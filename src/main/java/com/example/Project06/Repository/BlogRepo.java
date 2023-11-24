package com.example.Project06.Repository;

import com.example.Project06.Entity.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepo extends JpaRepository<Blogs,Integer> {

    List<Blogs> findByuserId(Integer userId);

}

