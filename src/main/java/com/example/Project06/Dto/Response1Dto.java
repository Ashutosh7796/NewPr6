package com.example.Project06.Dto;

import com.example.Project06.Entity.JobfairQue;
import lombok.Data;

import java.util.List;

@Data
public class Response1Dto {

        public String status;
        public List<JobfairQue> response;

        public Response1Dto(String status) {
            this.status = status;
        }
    }


