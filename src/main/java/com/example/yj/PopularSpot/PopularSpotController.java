package com.example.yj.PopularSpot;

import com.example.yj.entity.TouristSpot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/spot")
@RequiredArgsConstructor
public class PopularSpotController {
    private final PopulaSpotService populaSpotService;
    @GetMapping("/popSpot/{popSpot}")
    public String popSpotCon(@PathVariable("popSpot")String popSpot, Model model){

        List<TouristSpot> touristSpotList = populaSpotService.getPopSpot(popSpot);
        model.addAttribute("area", popSpot);
        model.addAttribute("touristSpotList", touristSpotList);
        return "popSpot_form";
    }
}
