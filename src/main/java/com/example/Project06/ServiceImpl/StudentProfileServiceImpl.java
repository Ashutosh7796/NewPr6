package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.HrCall.GetSingleHrCallDto;
import com.example.Project06.Dto.StudentProfileDto.GetSingleProfileDto;
import com.example.Project06.Dto.StudentProfileDto.StudentProfileDto;
import com.example.Project06.Entity.HrCall;
import com.example.Project06.Entity.StudentProfile;
import com.example.Project06.Entity.User;
import com.example.Project06.Repository.StudentProfRepo;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.StudentProfileService;
import com.example.Project06.exception.HrCallNotFoundException;
import com.example.Project06.exception.UserNotFoundExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfRepo studentProfRepo;

    private final UserRepository userRepository;

    @Override
    public String AddProfile(StudentProfileDto studentProfileDto, Integer userId) {
        Optional<User> user = userRepository.findById(userId);

        if(user.isPresent()) {
            User user1 = user.get();
            StudentProfile studentProfile = new StudentProfile(studentProfileDto);
            studentProfile.setUserUser(user1);
            studentProfRepo.save(studentProfile);
            return "Profile Created Successfully";
        }else {
            throw new UserNotFoundExceptions("User Not Found with Id:" + userId);
        }

    }

    @Override
    public GetSingleProfileDto getProfileById(Integer studnetProfileId) {
        Optional<StudentProfile> profile = studentProfRepo.findById(studnetProfileId);

        if(profile.isEmpty())
        {
            throw new RuntimeException("Profile Not Found by id " + studnetProfileId);
        }
        GetSingleProfileDto userDTO = new GetSingleProfileDto(profile.get());
        return userDTO;
    }

    @Override
    public List<GetSingleProfileDto> getAllProfiles(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<StudentProfile> allProfiles = studentProfRepo.findAll(pageable);

        List<GetSingleProfileDto> getallCalls = new ArrayList<>();

        for (StudentProfile profile : allProfiles) {
            GetSingleProfileDto profileDto = convertToDto(profile);
            getallCalls.add(profileDto);
        }

        return getallCalls;
    }

    @Override
    public void updateProfileDetails(GetSingleProfileDto profileDto) {
        StudentProfile profile = studentProfRepo.findById(profileDto.getStudentProfileId()).orElseThrow(()-> new RuntimeException("Profile Not Found with Id:" + profileDto.getStudentProfileId()));

        if (profileDto.getCourse() != null){
            profile.setCourse(profileDto.getCourse());
        }
        if (profileDto.getExperienceType() != null) {
            profile.setExperienceType(profileDto.getExperienceType());
        }
        if (profileDto.getWorkExperience() != null) {
            profile.setWorkExperience(profileDto.getWorkExperience());
        }
        if (profileDto.getLastWorkDuration() != null) {
            profile.setLastWorkDuration(profileDto.getLastWorkDuration());
        }
        if (profileDto.getLastCompany() != null) {
            profile.setLastCompany(profileDto.getLastCompany());
        }
        if (profileDto.getLastSalary() != null) {
            profile.setLastSalary(profileDto.getLastSalary());
        }
        if (profileDto.getPreviousDesignation() != null) {
            profile.setPreviousDesignation(profileDto.getPreviousDesignation());
        }
        if (profileDto.getCareerBreak() != null) {
            profile.setCareerBreak(profileDto.getCareerBreak());
        }
        if (profileDto.getHighestLevelOfEud() != null) {
            profile.setHighestLevelOfEud(profileDto.getHighestLevelOfEud());
        }
        if (profileDto.getCurrentLocation() != null) {
            profile.setCurrentLocation(profileDto.getCurrentLocation());
        }

        if (profileDto.getAvailableToJoin() != null) {
            profile.setAvailableToJoin(profileDto.getAvailableToJoin());
        }
        if (profileDto.getSpecialization() != null) {
            profile.setSpecialization(profileDto.getSpecialization());
        }
        if (profileDto.getCourseDuration() != null) {
            profile.setCourseDuration(profileDto.getCourseDuration());
        }
        if (profileDto.getSkills() != null) {
            profile.setSkills(profileDto.getSkills());
        }
        if (profileDto.getShortAboutYourself() != null) {
            profile.setShortAboutYourself(profileDto.getShortAboutYourself());
        }

        if (profileDto.getPreferredSalary() != null) {
            profile.setPreferredSalary(profileDto.getPreferredSalary());
        }

        studentProfRepo.save(profile);
    }

    @Override
    public String deleteProfileById(Integer studentProfileId) {
        studentProfRepo.findById(studentProfileId).orElseThrow(() -> new RuntimeException("Profile details Not found By Id"));
        studentProfRepo.deleteById(studentProfileId);
        return "Profile deleted Successfully ";
    }

    private GetSingleProfileDto convertToDto(StudentProfile studentProfile) {
        GetSingleProfileDto profile = new GetSingleProfileDto();
        profile.setCourse(studentProfile.getCourse());
        profile.setCareerBreak(studentProfile.getCareerBreak());
        profile.setAvailableToJoin(studentProfile.getAvailableToJoin());
        profile.setCourseDuration(studentProfile.getCourseDuration());
        profile.setExperienceType(studentProfile.getExperienceType());
        profile.setCurrentLocation(studentProfile.getCurrentLocation());
        profile.setStudentProfileId(studentProfile.getStudentProfileId());
        profile.setLastSalary(studentProfile.getLastSalary());
        profile.setLastCompany(studentProfile.getLastCompany());
        profile.setSkills(studentProfile.getSkills());
        profile.setSpecialization(studentProfile.getSpecialization());
        profile.setPreferredSalary(studentProfile.getPreferredSalary());
        profile.setWorkExperience(studentProfile.getWorkExperience());
        profile.setLastWorkDuration(studentProfile.getLastWorkDuration());
        profile.setPreviousDesignation(studentProfile.getPreviousDesignation());
        profile.setHighestLevelOfEud(studentProfile.getHighestLevelOfEud());
        profile.setShortAboutYourself(studentProfile.getShortAboutYourself());
        return profile;
    }
}

