package com.example.Project06.Controller;

import com.example.Project06.Dto.CompanyRegistrationDto;
import com.example.Project06.Service.CompanyService;
import com.example.Project06.exception.CompanyRegistrationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("company")
public class CompanyRegController {

    private final CompanyService companyService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCompany(@RequestBody CompanyRegistrationDto registrationDto) {
        try {
            companyService.registerCompany(registrationDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Company registered successfully.");
        } catch (CompanyRegistrationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
