package com.example.Project06.ServiceImpl;


import com.example.Project06.Dto.GetSingleBlogDto;
import com.example.Project06.Dto.HrCall.GetSingleHrCallDto;
import com.example.Project06.Dto.HrCall.HrCallDto;
import com.example.Project06.Entity.Blogs;
import com.example.Project06.Entity.Hr;
import com.example.Project06.Entity.HrCall;
import com.example.Project06.Entity.User;
import com.example.Project06.Repository.HrCallRepo;
import com.example.Project06.Repository.HrRepository;
import com.example.Project06.Service.HrCallService;
import com.example.Project06.exception.BlogNotFoundException;
import com.example.Project06.exception.HrCallNotFoundException;
import com.example.Project06.exception.HrNotFoundException;
import com.example.Project06.exception.UserNotFoundExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HrCallServiceImpl implements HrCallService {

    private final HrCallRepo hrCallRepo;

    private final HrRepository hrRepository;
    @Override
    public String AddHrCall(HrCallDto hrCallDto, Integer hrId) {
        Optional<Hr> hrOptional = hrRepository.findById(hrId);

        if (hrOptional.isPresent()) {
            Hr hr = hrOptional.get();
            HrCall call = new HrCall(hrCallDto);
            call.setHrHr(hr);
            hrCallRepo.save(call);
            return "Call Added Successfully";
        } else {
            throw new HrNotFoundException("Hr not found with ID: " + hrId);
        }
    }

    @Override
    public List<GetSingleHrCallDto> getCallByUserId(Integer userId) {
        List<HrCall> blogs = hrCallRepo.findByuserId(userId);

        if (blogs.isEmpty()) {
            throw new HrCallNotFoundException("Call Not Found by user id ");
        }

        return blogs.stream()
                .map(GetSingleHrCallDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public GetSingleHrCallDto getHrCallById(Integer hrCallId) {
        Optional<HrCall> call = hrCallRepo.findById(hrCallId);

        if(call.isEmpty())
        {
            throw new HrCallNotFoundException("HrCall Not Found by id ");
        }
        GetSingleHrCallDto userDTO = new GetSingleHrCallDto(call.get());
        return userDTO;
    }



    @Override
    public List<GetSingleHrCallDto> getAllHrCalls(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<HrCall> allcompanies = hrCallRepo.findAll(pageable);

        List<GetSingleHrCallDto> getallCalls = new ArrayList<>();

        for (HrCall call : allcompanies) {
            GetSingleHrCallDto hrCallDto = convertToDto(call);
            getallCalls.add(hrCallDto);
        }

        return getallCalls;
    }

    @Override
    public String deleteCallById(Integer hrCallId) {
        hrCallRepo.findById(hrCallId).orElseThrow(() -> new RuntimeException("Call details Not found By Id"));
        hrCallRepo.deleteById(hrCallId);
        return "Call deleted Successfully ";
    }

    private GetSingleHrCallDto convertToDto(HrCall hrCall) {
        GetSingleHrCallDto hrCallDto = new GetSingleHrCallDto();
        hrCallDto.setHrCallId(hrCall.getHrCallId());
        hrCallDto.setPosition(hrCall.getPosition());
        hrCallDto.setStatus(hrCall.getStatus());
        hrCallDto.setDate(hrCall.getDate());
        hrCallDto.setRespond(hrCall.getRespond());
        hrCallDto.setTime(hrCall.getTime());
        hrCallDto.setUserId(hrCall.getUserId());
        hrCallDto.setHrId(hrCall.getHrHr().getHrId());

        return hrCallDto;
    }
}
