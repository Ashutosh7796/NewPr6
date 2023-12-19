package com.example.Project06.Controller;

import com.example.Project06.Dto.Event.*;
import com.example.Project06.Dto.HrCall.GetSingleHrCallDto;
import com.example.Project06.Dto.HrCall.HrCallDto;
import com.example.Project06.Dto.HrCall.ResponseAllHrCallDto;
import com.example.Project06.Dto.HrCall.SingleHrCallDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Service.HrCallService;
import com.example.Project06.exception.*;
import com.example.Project06.utils.BaseResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/HrCall")
@RequiredArgsConstructor
public class HrCallController {

        private final HrCallService hrCallService;

        @PostMapping(value = "/addHrCall")
        public ResponseEntity<BaseResponseDTO> addHrCall(@RequestBody HrCallDto hrCallDto, Integer hrId) {
            try {
                String response = hrCallService.AddHrCall(hrCallDto, hrId);
                return ResponseEntity.status(HttpStatus.OK).body(new BaseResponseDTO("Success", response));
            }
            catch (HrNotFoundException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseDTO("Unsuccessful", "Hr Id Not Found, Error Occurred"));
            }
        }

        @GetMapping("/getById")
        public ResponseEntity<?> getByHrCallId(@RequestParam Integer hrCallId) {
            try {
                SingleHrCallDto responseDto = new SingleHrCallDto("Success");
                responseDto.setResponse(hrCallService.getHrCallById(hrCallId));
                return ResponseEntity.status(HttpStatus.OK).body(responseDto);
            } catch (HrCallNotFoundException e) {
                EventUpdateDto hrdto = new EventUpdateDto("Unsuccess");
                hrdto.setException(String.valueOf(e));
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hrdto);

            }
        }

        @GetMapping("/getAllHrCalls")
        public ResponseEntity<ResponseAllHrCallDto> getAllHrCalls(@RequestParam int pageNo,
                                                                 @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
            try {
                List<GetSingleHrCallDto> calls = hrCallService.getAllHrCalls(pageNo, pageSize);
                ResponseAllHrCallDto responseAllCompnayDto = new ResponseAllHrCallDto("Success");
                responseAllCompnayDto.setList(calls);
                return ResponseEntity.status(HttpStatus.OK).body(responseAllCompnayDto);
            } catch (PageNotFoundException e) {
                ResponseAllHrCallDto dto = new ResponseAllHrCallDto("Unsuccess");
                dto.setException("Page Not Found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
            }
        }
    @GetMapping("/getCallByUserId")
    public ResponseEntity<?> getCallsByUserId(@RequestParam Integer userId) {
        try {
            List<GetSingleHrCallDto> blogDtos = hrCallService.getCallByUserId(userId);

            if (blogDtos.isEmpty()) {
                ResponseAllHrCallDto responseDto = new ResponseAllHrCallDto("No blogs found for the given user ID");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);

            } else {
                ResponseAllHrCallDto responseDto = new ResponseAllHrCallDto("Success");
                responseDto.setList(blogDtos);
                return ResponseEntity.status(HttpStatus.OK).body(responseDto);
            }
        } catch (BlogNotFoundException e) {
            ResponseAllHrCallDto responseDto = new ResponseAllHrCallDto("Unsuccessful");
            responseDto.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCallById(@RequestParam Integer hrCallId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", hrCallService.deleteCallById(hrCallId)));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", e.getMessage()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", e.getMessage()));
        }
    }

}
