package com.example.Project06.Service;

import com.example.Project06.Dto.ItTraining.ItTrainingDTO;

import java.util.List;


public interface ItTrainingService {

    public String AddItTraining(ItTrainingDTO itTrainingDTO);

    public ItTrainingDTO GetById(Integer itTrainingId);

    public List<ItTrainingDTO> GetAllitTraining();

    public  String EditItTraining(ItTrainingDTO itTrainingDTO, Integer itTrainingId);


   public String deleteItTraining(Integer itTrainingId);
}
