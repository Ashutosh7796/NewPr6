package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.ItTraining.ItTrainingDTO;
import com.example.Project06.Entity.ItTraining;
import com.example.Project06.Repository.ItTrainingRepo;
import com.example.Project06.Service.ItTrainingService;
import com.example.Project06.exception.ItTrainingNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public ItTrainingDTO GetById(Integer itTrainingId) {
        Optional<ItTraining> itTraining= itTrainingRepo.findById(itTrainingId);
        if (itTraining.isEmpty()){
            throw new ItTrainingNotFoundException("IT Training not found", HttpStatus.NOT_FOUND);
        }
        ItTrainingDTO itTrainingDTO = new ItTrainingDTO(itTraining.get());
        itTrainingDTO.setItTrainingId(itTrainingId);
        return itTrainingDTO;
    }

    @Override
    public List<ItTrainingDTO> GetAllitTraining() {
        List<ItTraining> itTrainings = itTrainingRepo.findAll();
        return itTrainings.stream()
                .map(ItTrainingDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public String EditItTraining(ItTrainingDTO itTrainingDTO, Integer itTrainingId) {
    ItTraining itTraining = itTrainingRepo.findById(itTrainingId).orElseThrow(()-> new ItTrainingNotFoundException("IT Training not found",HttpStatus.NOT_FOUND));
        if (itTrainingDTO.getDomain() != null) {
            itTraining.setDomain(itTrainingDTO.getDomain());
        }
        if (itTrainingDTO.getMode() != null) {
            itTraining.setMode(itTrainingDTO.getMode());
        }
        if (itTrainingDTO.getMentor() != null) {
            itTraining.setMentor(itTrainingDTO.getMentor());
        }
        if (itTrainingDTO.getCost() != null) {
            itTraining.setCost(itTrainingDTO.getCost());
        }
        if (itTrainingDTO.getTopic() != null) {
            itTraining.setTopic(itTrainingDTO.getTopic());
        }
        if (itTrainingDTO.getStartDate() != null) {
            itTraining.setStartDate(itTrainingDTO.getStartDate());
        }
        if (itTrainingDTO.getEndDate() != null) {
            itTraining.setEndDate(itTrainingDTO.getEndDate());
        }
        if (itTrainingDTO.getDuration() != null) {
            itTraining.setDuration(itTrainingDTO.getDuration());
        }
        itTrainingRepo.save(itTraining);
        return "itTraining updated ";
    }

    @Override
    public String deleteItTraining(Integer itTrainingId) {
        ItTrainingDTO exitItTraining = GetById(itTrainingId);
        if(exitItTraining== null ){
            throw new ItTrainingNotFoundException("IT Training ID"+itTrainingId + "not found");
        }
        itTrainingRepo.deleteById(itTrainingId);
        return "IT Training ID"+ itTrainingId + "has been deleted successfully";

    }


}
