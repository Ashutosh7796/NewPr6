package com.example.Project06.Controller;

import com.example.Project06.Dto.Plan.PlanDto;
import com.example.Project06.Dto.Plan.ResponseGetAllPlanDto;
import com.example.Project06.Dto.Plan.ResponseSinglePlanDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Service.PlanService;
import com.example.Project06.exception.PageNotFoundException;
import com.example.Project06.exception.PlanNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("plan")
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;

    @PostMapping(value = "/add")
    public ResponseEntity<ResponseDto> planAdded(@RequestBody PlanDto planDto) {
        try {
            String result = planService.AddPlan(planDto);
            return (ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", result)));
        } catch (PlanNotFoundException planNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", "Plan Not found"));

        }
    }

    @GetMapping("/getAllPlan")
    public ResponseEntity<ResponseGetAllPlanDto> getAllPlan(@RequestParam int pageNo) {

        try {
            List<PlanDto> listOfPlan = planService.getAllPlanWithPages(pageNo);
            ResponseGetAllPlanDto responseGetAllPlanDto = new ResponseGetAllPlanDto("success");
            responseGetAllPlanDto.setList(listOfPlan);
            return ResponseEntity.status(HttpStatus.OK).body(responseGetAllPlanDto);
        } catch (PlanNotFoundException planNotFoundException) {
            ResponseGetAllPlanDto responseGetAllPlanDto = new ResponseGetAllPlanDto("unsuccess");
            responseGetAllPlanDto.setException("Plan not found");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGetAllPlanDto);
        } catch (PageNotFoundException pageNotFoundException) {
            ResponseGetAllPlanDto responseGetAllPlanDto = new ResponseGetAllPlanDto("unsuccess");
            responseGetAllPlanDto.setException("Page not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGetAllPlanDto);
        }
    }

    @GetMapping("/getPlan")
    public ResponseEntity<ResponseSinglePlanDto> FindPlanById(@RequestParam Integer PlanId) {
        try {
            ResponseSinglePlanDto responseSinglePlanDto = new ResponseSinglePlanDto("success");
            PlanDto plan = planService.findById(PlanId);
            responseSinglePlanDto.setObject(plan);
            return ResponseEntity.status(HttpStatus.OK).body(responseSinglePlanDto);
        } catch (PlanNotFoundException planNotFoundException) {
            ResponseSinglePlanDto responseSinglePlanDto = new ResponseSinglePlanDto("unsuccess");
            responseSinglePlanDto.setException("Plan not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseSinglePlanDto);
        }
    }

    @GetMapping("/getPlanByStatus")
    public ResponseEntity<ResponseGetAllPlanDto> getPlansByStatusWithPages(@RequestParam int pageNo, boolean status) {
        try {
            List<PlanDto> listOfPlanByStatus = planService.getPlanByStatusWithPages(pageNo, status);
            ResponseGetAllPlanDto responseGetAllPlanDto = new ResponseGetAllPlanDto("success");
            responseGetAllPlanDto.setList(listOfPlanByStatus);
            return ResponseEntity.status(HttpStatus.OK).body(responseGetAllPlanDto);
        } catch (PlanNotFoundException planNotFoundException) {
            ResponseGetAllPlanDto responseGetAllPlanDto = new ResponseGetAllPlanDto("unsuccess");
            responseGetAllPlanDto.setException("Plan not found");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGetAllPlanDto);
        } catch (PageNotFoundException pageNotFoundException) {
            ResponseGetAllPlanDto responseGetAllPlanDto = new ResponseGetAllPlanDto("unsuccess");
            responseGetAllPlanDto.setException("Page not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGetAllPlanDto);
        }
    }

    @PutMapping("/edit/{PlanId}")
    public ResponseEntity<ResponseDto> planEdit(@RequestBody PlanDto planDto, @PathVariable Integer PlanId) {
        try {
            String result = planService.EdgitPlan(planDto,PlanId);
            return (ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", result)));
        } catch (PlanNotFoundException planNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", "Plan Not found"));

        }
    }


    @PatchMapping("/update/{PlanId}")
    public ResponseEntity<ResponseDto> updatePlanFields(@RequestBody PlanDto planDto, @PathVariable Integer PlanId) {
        try {
            String result = planService.updatePlanFields(planDto,PlanId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", result));
        }catch (PlanNotFoundException planNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", "Plan Not found"));

        }
    }

    @DeleteMapping("/delete/{PlanId}")
    public ResponseEntity<ResponseDto> deletePlan(@PathVariable Integer PlanId) {
        try {
            String result = planService.deletePlan(PlanId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", result));
        } catch (PlanNotFoundException planNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", "Plan Not found"));
        }
    }
}
