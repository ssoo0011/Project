package com.example.yj.repository;

import com.example.yj.entity.TouristSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TouristSpotRepository extends JpaRepository<TouristSpot, String> {

    @Query(value = "SELECT * FROM tourist_spot WHERE area = :area ORDER BY visit_num DESC LIMIT 6", nativeQuery = true)
    List<TouristSpot> findByArea(String area); //지역으로 찾기

}
