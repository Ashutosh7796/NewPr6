package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.BootcampDto.BootcampDto;
import com.example.Project06.Entity.Bootcamp;
import com.example.Project06.Entity.BootcampBookings;
import com.example.Project06.Repository.BootcampBookingsRepo;
import com.example.Project06.Repository.BootcampRepo;
import com.example.Project06.Service.IBootcamp;
import com.example.Project06.exception.BootcampNotFoundByIdException;
import com.example.Project06.exception.BootcampsBookingNotFoundById;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class BootcampImp implements IBootcamp {
    private final BootcampRepo bootcampRepo;
    private final BootcampBookingsRepo bootcampBookingsRepo;


    @Override
    public void saveBootcampDetails(BootcampDto bootcampDto) {
//        BootcampBookings bootcampBookings = bootcampBookingsRepo.findByBannnerId(bootcampDto.getBootcampBootcampBootcampBookingsesId());
        Bootcamp bootcamp = new Bootcamp(bootcampDto);
//        bootcamp.setBootcampBootcampBootcampBookingses(bootcampBookings);
        bootcampRepo.save(bootcamp);
    }

    @Override
    public Bootcamp getBootcampDetailsById(Integer bootcampId) {
        return this.bootcampRepo.findById(bootcampId).orElseThrow(() -> new BootcampNotFoundByIdException("bootcampdetails not found by Id"));
    }


    @Override
    public List<Bootcamp> getAllBootcampDetails() {
        return this.bootcampRepo.findAll();
    }

    @Override
    public String updateBootcampDetails(String bootcampTital, String bootcampDetails, String time, String status, String location, String tagLine, String photo, String price, Integer bootCampId) {
//        return this.bootcampRepo.findById(bootcampId).orElseThrow(() -> new BootcampNotFoundByIdException("bootcampdetails not found by Id"));

        Bootcamp bootcamp = bootcampRepo.findById(bootCampId).orElseThrow(()->new RuntimeException("bootcamp not found by id"));

        bootcamp.setBootcampTital(bootcampTital.length()>0 ? bootcampTital : bootcamp.getBootcampTital());
//        bootcamp.setDate(date.length()>0 ? bootcampTital : bootcamp.getBootcampTital());
//        bootcamp.setBootcampDate(bootcampTital.length()>0 ? bootcampTital : bootcamp.getBootcampTital());
        bootcamp.setTime(time.length()>0 ? time : bootcamp.getTime());
        bootcamp.setStatus(status.length()>0 ? status : bootcamp.getStatus());
        bootcamp.setLocation(location.length()>0 ? location : bootcamp.getLocation());
        bootcamp.setTagLine(tagLine.length()>0 ? tagLine : bootcamp.getTagLine());
        bootcamp.setPhoto(photo.length()>0 ? photo : bootcamp.getPhoto());
        bootcamp.setPrice(price.length()>0 ? price : bootcamp.getPrice());
        System.err.println(bootcamp.toString());
        bootcampRepo.save(bootcamp);


        return "banner details updated";
    }

    @Override
    public String updateBootcampDetails(String taital, String status, String name, Integer bootcampId) {
        return null;
    }

    @Override
    public String deleteBootcampDetailsByID(Integer bootcampId) {
        bootcampRepo.findById(bootcampId).orElseThrow(() -> new BootcampNotFoundByIdException("bootcamp details Not found By Id"));
        bootcampRepo.deleteById(bootcampId);
        return "bootcamp detals deleted by id";
    }
}
