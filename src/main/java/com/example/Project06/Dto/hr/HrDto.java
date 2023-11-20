package com.example.Project06.Dto.hr;

import com.example.Project06.Entity.Company;
import com.example.Project06.Entity.Hr;
import com.example.Project06.Entity.User;
import lombok.Data;

@Data
public class HrDto {

    private String digignastion;


    private String status;


    private String refNoOfCompany;


    private Integer companyId;


    private Integer userId;

    public HrDto() {
    }

    public HrDto(Hr hr) {
      this.digignastion = hr.getDesignation();
        this.status = hr.getHrstatus();
        this.refNoOfCompany = hr.getRefNoOfCompany();
        this.companyId = hr.getCompanyCompany().getCompanyId();
        this.userId = hr.getUserUser().getUser_id();
    }
}
