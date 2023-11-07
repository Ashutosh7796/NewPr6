package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.ItTrianningBooking.ItTrianningBookingDto;
import com.example.Project06.Entity.ItTraining;
import com.example.Project06.Entity.ItTrainingBooking;
import com.example.Project06.Entity.User;
import com.example.Project06.Repository.ItTrainingRepo;
import com.example.Project06.Repository.ItTrianningBookingRepo;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.ItTrainingBookingService;
import com.example.Project06.exception.ItTrainingBookingException;
import com.example.Project06.exception.ItTrainingNotFoundException;
import com.example.Project06.exception.UserNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ItTrainingBookingServiceImpl implements ItTrainingBookingService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ItTrainingRepo itTrainingRepo;
    @Autowired
    ItTrianningBookingRepo itTrianningBookingRepo;



    @Override
    public String AddItTrainingBooking(ItTrianningBookingDto itTrianningBookingDto) {
        Optional<User> user = userRepository.findById(itTrianningBookingDto.getUserId());
        Optional<ItTraining> itTraining;
        itTraining = itTrainingRepo.findById(Integer.valueOf(itTrianningBookingDto.getItTrainingId()));

        if (user.isPresent() && itTraining.isPresent()) {
            ItTrainingBooking itTrainingBooking = new ItTrainingBooking(itTrianningBookingDto);
            itTrianningBookingRepo.save(itTrainingBooking);
            return "Booking saved";
        } else {
            if (!user.isPresent()) {
                throw new UserNotFoundExceptions("User not found");
            } else {
                throw new ItTrainingNotFoundException("ItTraining not found");
            }
        }
    }


    @Override
    public ItTrianningBookingDto GetbyId(Integer itTrainingBookingId) {
        Optional<ItTrainingBooking> itTrainingBooking = itTrianningBookingRepo.findById(itTrainingBookingId);
        if (itTrainingBooking.isEmpty()) {
            throw new ItTrainingBookingException("IT Training booking not found", HttpStatus.NOT_FOUND);
        }
         ItTrianningBookingDto itTrianningBookingDto =new ItTrianningBookingDto(itTrainingBooking.get());
         itTrianningBookingDto.setItTrainingBookingId(itTrainingBookingId);
         return itTrianningBookingDto;
    }

    @Override
    public List<ItTrianningBookingDto> AllItBooking() {
        List<ItTrainingBooking> itTrainingBookings = itTrianningBookingRepo.findAll();
        return itTrainingBookings.stream()
                .map(ItTrianningBookingDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public String ItBookingDelete(Integer itTrainingBooking) {
        ItTrianningBookingDto itTrianningBookingDto = GetbyId(itTrainingBooking);
        if(itTrianningBookingDto== null ){
            throw new ItTrainingNotFoundException("IT Training booking ID"+itTrainingBooking + "not found");
        }
        itTrainingRepo.deleteById(itTrainingBooking);
        return "IT Training booking ID"+ itTrainingBooking + "has been deleted successfully";

    }


    @Override
    public List<ItTrianningBookingDto> getByUserId(Integer UserId) {
        return null ;
    }

    @Override
    public List<ItTrianningBookingDto> getByItTrainingId(Integer itTrainingItTraining) {
        return null ;
    }


}
