package com.example.Project06.Dto;

import com.example.Project06.Entity.Company;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetAllCompanies {

    private String gestnNo;
    private String companyServices;
    private String companyName;
    private String companyType;
    private String companyLevel;
    private String logo;
    private String CompanyStatus;
    private String officeAddress;
    private String companyLocations;
    private String oneCompanyDoc;
    private String refNo;

    public GetAllCompanies (Company company){
        this.companyServices = company.getCompanyServices();
        this.companyName = company.getCompanyName();
        this.companyType = company.getCompanyType();
        this.companyLevel = company.getCompanyLevel();
        this.logo = company.getLogo();
        this.CompanyStatus = company.getCompanyStatus();
        this.officeAddress = company.getOfficeAddress();
        this.companyLocations = company.getCompanyLocations();
        this.oneCompanyDoc = company.getOneCopmpanyDoc();
        this.refNo = company.getRefNo();
    }


}
