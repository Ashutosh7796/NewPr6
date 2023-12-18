package com.example.Project06.Repository;

import com.example.Project06.Entity.JobSave;
import com.example.Project06.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSaveRepo extends JpaRepository <JobSave, Integer> {
    public List<JobSave> findByUserId(Integer userId);

    boolean existsByUserIdAndJobId(Integer userId, Integer jobId);


}
