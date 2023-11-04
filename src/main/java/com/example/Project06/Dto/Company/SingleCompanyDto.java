package com.example.Project06.Dto.Company;

import com.example.Project06.Dto.GetAllCompanies;
import lombok.Data;

@Data
public class SingleCompanyDto {

        private String status;
        private GetAllCompanies Response;

        public SingleCompanyDto(String status) {
            this.status = status;
        }


    }


