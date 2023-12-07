package com.example.Project06.Repository;


import com.example.Project06.Entity.LiveProjectBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface LiveProjectBookingRepo extends JpaRepository<LiveProjectBooking,Integer> {

    List<LiveProjectBooking> findByUserId(Integer userId);
    @Query("SELECT lpb FROM LiveProjectBooking lpb WHERE lpb.liveProjectID = :liveProjectID")
    List<LiveProjectBooking> findByLiveProjectID(@Param("liveProjectID") Integer liveProjectID);


}

