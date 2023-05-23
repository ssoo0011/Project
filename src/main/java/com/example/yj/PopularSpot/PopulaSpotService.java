package com.example.yj.PopularSpot;

import com.example.yj.entity.TouristSpot;
import com.example.yj.repository.TouristSpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PopulaSpotService {
    private final TouristSpotRepository touristSpotRepository;
    public List<TouristSpot> getPopSpot(String popSpot) {
        List<TouristSpot> touristSpotList = touristSpotRepository.findByArea(popSpot);
        return touristSpotList;
    }
}
