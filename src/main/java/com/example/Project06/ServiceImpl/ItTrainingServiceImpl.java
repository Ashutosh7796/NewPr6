package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.ItTraining.ItTrainingDTO;
import com.example.Project06.Entity.ItTraining;
import com.example.Project06.Repository.ItTrainingRepo;
import com.example.Project06.Service.ItTrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItTrainingServiceImpl implements ItTrainingService {

    private final ItTrainingRepo itTrainingRepo;

    @Override
    public String AddItTraining(ItTrainingDTO itTrainingDTO) {

        ItTraining itTraining = new ItTraining (itTrainingDTO);
        itTrainingRepo.save(itTraining);
        return "IT Training added";

    }
}
