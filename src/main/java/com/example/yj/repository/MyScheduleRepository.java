package com.example.yj.repository;

import com.example.yj.entity.MySchedule;
import com.example.yj.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MyScheduleRepository extends JpaRepository<MySchedule, Long> {

    List<MySchedule> findByUserId(String userId);

    @Query(value = "SELECT spot\n" +
            "FROM   my_schedule\n" +
            "GROUP  BY spot\n" +
            "ORDER  BY Count(spot) DESC\n" +
            "LIMIT  4; ", nativeQuery = true)
    List<String> findPopularSpot(); //인기 젤 많은 장소 찾기



}
