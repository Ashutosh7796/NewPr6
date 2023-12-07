package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.ItTrianningBooking.ItTrianningBookingDto;
import com.example.Project06.Dto.liveProjectBooking.LiveProjectBookingDto;
import com.example.Project06.Entity.*;
import com.example.Project06.Repository.LiveProjectBookingRepo;
import com.example.Project06.Repository.LiveProjectRepo;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.LiveProjectBookingService;
import com.example.Project06.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LiveProjectServiceBookingImpl implements LiveProjectBookingService {


    @Autowired
    UserRepository userRepository;
    @Autowired
    LiveProjectRepo liveProjectRepo;
    @Autowired
    LiveProjectBookingRepo liveProjectBookingRepo;


    @Override
    public String AddLiveProjectBooking(LiveProjectBookingDto liveProjectBookingDto) {
        Optional<User> user = userRepository.findById(Integer.valueOf(liveProjectBookingDto.getUserId()));
        Optional<LiveProject> liveProject;
        liveProject = liveProjectRepo.findById(Integer.valueOf(liveProjectBookingDto.getLiveProjectID()));


        if (user.isPresent() && liveProject.isPresent()) {
            LiveProjectBooking liveProjectBooking = new LiveProjectBooking(liveProjectBookingDto);
            liveProjectBookingRepo.save(liveProjectBooking);
            return "Booking saved";

        } else {
            if (!user.isPresent()) {
                throw new UserNotFoundExceptions("User not found");
            } else {
                throw new LiveProjectNotFoundException("live project not found not found");
            }
        }
    }

    @Override
    public LiveProjectBookingDto GetbyId(Integer liveProjectBookingId) {
        Optional<LiveProjectBooking> liveProjectBooking = liveProjectBookingRepo.findById(liveProjectBookingId);

        if (liveProjectBooking.isEmpty()) {
            throw new LiveProjectBookingNotFoundException("IT Training booking not found", HttpStatus.NOT_FOUND);
        }
        LiveProjectBookingDto liveProjectBookingDto= new LiveProjectBookingDto(liveProjectBooking.get());
        liveProjectBookingDto.setLiveProjectBookingId(liveProjectBookingId);
        return liveProjectBookingDto;
    }

    @Override
    public List<LiveProjectBookingDto> getAllByliveProjectID(Integer liveProjectID) {
        List<LiveProjectBooking> liveProjectBookings = liveProjectBookingRepo.findByLiveProjectID(liveProjectID);

        if (liveProjectBookings.isEmpty()) {
            throw new LiveProjectBookingNotFoundException("No live Project bookings found for liveProjectID: " + liveProjectID, HttpStatus.NOT_FOUND);
        }

        return liveProjectBookings.stream()
                .map(LiveProjectBookingDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<LiveProjectBookingDto> AllLiveProjectBooking() {
        List<LiveProjectBooking> liveProjectBookings = liveProjectBookingRepo.findAll();
        return liveProjectBookings.stream()
                .map(LiveProjectBookingDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public String LiveProjectBookingDelete(Integer liveProjectBookingId) {
        LiveProjectBookingDto liveProjectBookingDto = GetbyId(liveProjectBookingId);
        if(liveProjectBookingDto== null ){
            throw new LiveProjectBookingNotFoundException("live Project booking ID"+liveProjectBookingId + "not found");
        }
        liveProjectBookingRepo.deleteById(liveProjectBookingId);
        return "live Project  booking ID"+ liveProjectBookingId + "has been deleted successfully";
    }

    @Override
    public List<LiveProjectBookingDto> getByUserId(Integer UserId) {
        List<LiveProjectBooking> liveProjectBookings = liveProjectBookingRepo.findByUserId(UserId);
        return liveProjectBookings.stream()
                .map(LiveProjectBookingDto::new)
                .collect(Collectors.toList());
    }
}
