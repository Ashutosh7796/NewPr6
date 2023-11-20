package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.hr.HrDto;
import com.example.Project06.Entity.Banner;
import com.example.Project06.Entity.Company;
import com.example.Project06.Entity.Hr;
import com.example.Project06.Entity.User;
import com.example.Project06.Repository.CompanyRepo;
import com.example.Project06.Repository.HrRepo;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.IHr;
import com.example.Project06.exception.BannerNotFoundByIdException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HrImp implements IHr {
    private final HrRepo hrRepo;
    private final UserRepository userRepository;
    private final CompanyRepo companyRepo;
    @Override
    public void saveHrDetails(HrDto hrDto) {

        User user = userRepository.findById(hrDto.getUserId()).orElseThrow(()->new RuntimeException("user not found by id"));
        Company company = companyRepo.findById(hrDto.getCompanyId()).orElseThrow(()-> new RuntimeException("company not found by id"));
        Hr hr = new Hr(hrDto);
        hr.setCompanyCompany(company);
        hr.setUserUser(user);
        hrRepo.save(hr);

    }


    @Override
    public HrDto getBootcampDetailsById(Integer hrId) {
         Hr hr = hrRepo.findById(hrId).orElseThrow(()->new RuntimeException("hr id not found"));
        return new HrDto(hr);

    }

    @Override
    public List<HrDto> getAllBootcampDetails() {
        return hrRepo.findAll().stream().map(HrDto::new).collect(Collectors.toList());
    }

    @Override
    public String updateBootcampDetails(String digignastion, String status, String refNoOfCompany, Integer hrId) {
        Hr hr = hrRepo.findById(hrId).orElseThrow(() -> new RuntimeException("hr details Not found By Id"));

        hr.setDesignation(digignastion.length()>0 ? digignastion : hr.getDesignation());
        hr.setHrstatus(status.length()>0 ? status : hr.getHrstatus());
        hr.setRefNoOfCompany(refNoOfCompany.length()>0 ? refNoOfCompany : hr.getRefNoOfCompany());
        hrRepo.save(hr);
        return "hr details updated";
    }

    @Override
    public String deleteById(Integer hrId) {
       hrRepo.findById(hrId).orElseThrow(() -> new RuntimeException("hr details Not found By Id"));
       hrRepo.deleteById(hrId);
       return "hr details deleted ";
    }
}
