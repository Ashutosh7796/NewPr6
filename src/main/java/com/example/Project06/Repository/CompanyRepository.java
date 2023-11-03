package com.example.Project06.Repository;

import com.example.Project06.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findByGestnNo(String gestnNo);
}
