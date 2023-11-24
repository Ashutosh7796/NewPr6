package com.example.Project06.Repository;

import com.example.Project06.Entity.ItTraining;
import com.example.Project06.Entity.LiveProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface LiveProjectRepo extends JpaRepository<LiveProject,Integer>, JpaSpecificationExecutor<ItTraining> {


    }

