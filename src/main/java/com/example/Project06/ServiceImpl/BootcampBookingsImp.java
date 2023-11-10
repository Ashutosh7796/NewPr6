package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.BootcampBookingsDto.BootcampBookingsDto;
import com.example.Project06.Entity.Bootcamp;
import com.example.Project06.Entity.BootcampBookings;
import com.example.Project06.Repository.BootcampBookingRepo;
import com.example.Project06.Repository.BootcampRepo;
import com.example.Project06.Service.IBootcampBookings;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootcampBookingsImp implements IBootcampBookings {
    private final BootcampBookingRepo bootcampBookingRepo;
    private final BootcampRepo bootcampRepo;

    @Override
    public void save(BootcampBookingsDto bootcampBookingsDto) {
        Bootcamp bootcamp=bootcampRepo.findById(bootcampBookingsDto.getBootcampBootcampID()).orElseThrow(()->new RuntimeException("bootcamp not found by id "));
        BootcampBookings bootcampBookings = new BootcampBookings(bootcampBookingsDto);
        bootcampBookings.setBootcampBootcamp(bootcamp);
        bootcampBookingRepo.save(bootcampBookings);
    }

    @Override
    public List<BootcampBookingsDto> getAllBootcampDetails() {
        return bootcampBookingRepo.findAll().stream().map(BootcampBookingsDto::new).collect(Collectors.toList());
    }

    @Override
    public BootcampBookingsDto getById(Integer bootcampId) {
        return bootcampBookingRepo.findById(bootcampId).map(BootcampBookingsDto::new).orElseThrow(()->new RuntimeException("bootcamp bookings not found by id"));
    }

    @Override
    public String updateBootcampDetails(OffsetDateTime date, String status, Integer bootcampbookingId) {
        BootcampBookings bootcampBookings = bootcampBookingRepo.findById(bootcampbookingId).orElseThrow(() -> new RuntimeException("bootcampbooking details Not found By Id"));

        bootcampBookings.setDate((String.valueOf(date)).length()>0 ? date : bootcampBookings.getDate());
        bootcampBookings.setStatus(status.length()>0 ? status : bootcampBookings.getStatus());
        bootcampBookingRepo.save(bootcampBookings);
        return "bootcamp booking details updated";
    }

    @Override
    public String deleteById(Integer bootcampbookingId) {
        BootcampBookings bootcampBookings = bootcampBookingRepo.findById(bootcampbookingId).orElseThrow(() -> new RuntimeException("bootcampbooking details Not found By Id"));
        bootcampBookingRepo.deleteById(bootcampbookingId);
        return "booking details deleted";
    }
}
