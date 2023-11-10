package com.example.Project06.Service;

import com.example.Project06.Dto.GetAllCompanies;

import java.util.List;

public interface CompanyService {

    List<GetAllCompanies> getAllCompanies(int pageNo, int pageSize);

    GetAllCompanies findByCompanyId(int companyId);
}
