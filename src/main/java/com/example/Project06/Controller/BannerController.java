package com.example.Project06.Controller;

import com.example.Project06.Dto.BannerDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Dto.ResponseObjectDto;
import com.example.Project06.Dto.ResponseObjectSingleDto;
import com.example.Project06.Service.IBanner;
import com.example.Project06.exception.BannerNotFoundByIdException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/banner")
public class BannerController {
    private final IBanner iBanner;

    @PostMapping("/post")
    public ResponseEntity<?> saveBanner(@RequestBody BannerDto bannerDto) {
        iBanner.saveBannerDetails(bannerDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success","Banner details added"));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam Integer bannerId) {
        try {
            ResponseObjectSingleDto responseObjectSingleDto = new ResponseObjectSingleDto("success");
            responseObjectSingleDto.setResponse(iBanner.getBannerDetailsById(bannerId));
            return ResponseEntity.status(HttpStatus.OK).body(responseObjectSingleDto);
        }catch (BannerNotFoundByIdException e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }
    @GetMapping("/getAllBannerDetails")
    public ResponseEntity<?> getById() {
        try {
            ResponseObjectDto responseObjectDto = new ResponseObjectDto("success");
            responseObjectDto.setResponse(iBanner.getAllBannerDetails());
            return ResponseEntity.status(HttpStatus.OK).body(responseObjectDto);
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<?> getById(
            @RequestParam String taital,
            @RequestParam String status,
            @RequestParam String name,
            @RequestParam Integer bannerId

    ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",iBanner.updateBannerDetails(taital,status,name,bannerId)));
        }catch (BannerNotFoundByIdException e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteById( @RequestParam Integer bannerId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",iBanner.deleteBannerDetailsByID(bannerId)));
        }catch (BannerNotFoundByIdException e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }

}
