package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.CompanyRegistrationDto;
import com.example.Project06.Dto.RegisterDto;
import com.example.Project06.Entity.Company;
import com.example.Project06.Entity.Role;
import com.example.Project06.Entity.User;
import com.example.Project06.Repository.CompanyRepository;
import com.example.Project06.Repository.RoleRepository;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.CompanyService;
import com.example.Project06.Service.UserService;
import com.example.Project06.exception.CompanyRegistrationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Override
    public void registerCompany(CompanyRegistrationDto registrationDto) {
        try {
            User user = createUser(registrationDto);

            Company company = new Company();
            company.setCompanyName(registrationDto.getCompanyName());
            company.setGestnNo(registrationDto.getGestnNo());
            company.setCompanyServices(registrationDto.getCompanyServices());
            company.setCompanyType(registrationDto.getCompanyType());
            company.setCompanyLevel(registrationDto.getCompanyLevel());
            company.setLogo(registrationDto.getLogo());
            company.setOfficeAddress(registrationDto.getOfficeAddress());
            company.setCompanyLocations(registrationDto.getCompanyLocations());
            company.setOneCopmpanyDoc(registrationDto.getOneCompanyDoc());
            company.setRefNo(registrationDto.getRefNo());
            company.setStatus(registrationDto.getStatus());
            company.setUserUser(user);

            companyRepository.save(company);
        } catch (Exception e) {
            throw new CompanyRegistrationException("Failed to register the user and company. " + e.getMessage());
        }
    }

    private User createUser(CompanyRegistrationDto registrationDto) {
        User user = new User();
        user.setFullName(registrationDto.getFullName());
        user.setEmail(registrationDto.getEmail());
        user.setMoNumber(registrationDto.getMoNumber());

        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));

        user.setStatus(registrationDto.getStatus());

        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName(registrationDto.getRole());
        roles.add(role);
        user.setRoles(roles);

        userRepository.save(user);

        return user;
    }

}
