package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.Planning.CareerPlaningDto;
import com.example.Project06.Dto.hr.HrDto;
import com.example.Project06.Entity.CareerPlanning;
import com.example.Project06.Entity.Hr;
import com.example.Project06.Repository.CareerPlanningRepository;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.CareerPlanningService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CareerPlanningServiceImpl implements CareerPlanningService {

    private final CareerPlanningRepository careerPlanningRepository;

    private final UserRepository userRepository;


    @Override
    public void createCareerPlan(CareerPlaningDto careerPlaningDto) {
        userRepository.findById(careerPlaningDto.getUserId()).orElseThrow(()->new RuntimeException("career plans not found by id"));
        CareerPlanning careerPlanning = new CareerPlanning(careerPlaningDto);

        careerPlanningRepository.save(careerPlanning);
    }

    @Override
    public CareerPlaningDto getPlanById(Integer careerPlanning) {
        CareerPlanning careerPlanning1 = careerPlanningRepository.findById(careerPlanning).orElseThrow(()-> new RuntimeException("id not found"));
        return new CareerPlaningDto(careerPlanning1);
    }

    @Override
    public List<CareerPlaningDto> getAllCareerPlans() {
        return careerPlanningRepository.findAll().stream().map(CareerPlaningDto::new).collect(Collectors.toList());
    }

    @Override
    public String deleteById(Integer careerPlanning) {
        careerPlanningRepository.findById(careerPlanning).orElseThrow(()-> new RuntimeException("Careers Plan Not found"));
        careerPlanningRepository.deleteById(careerPlanning);
        return "career plan delete";
    }

    @Override
    public String updateCareerPlans(String domain, String mode, OffsetDateTime slot, String cost, String status, Integer careerPlanning) {
        CareerPlanning careerPlanning1 =careerPlanningRepository.findById(careerPlanning).orElseThrow(()-> new RuntimeException("Career Plans Not Found Id"));

        careerPlanning1.setDomain(domain.length()>0 ? domain : careerPlanning1.getDomain());
        careerPlanning1.setMode(mode.length()>0 ? status : careerPlanning1.getMode());
        careerPlanning1.setSlot(slot != null ? slot : careerPlanning1.getSlot());
        careerPlanning1.setCost(cost.length() > 0 ? cost : careerPlanning1.getCost());
        careerPlanning1.setStatus(status.length()>0 ? status : careerPlanning1.getStatus());
        careerPlanningRepository.save(careerPlanning1);
        return "Career Plans Update Successfully";
    }



}
