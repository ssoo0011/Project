package com.example.yj.mySchedule;

import com.example.yj.entity.MySchedule;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MyScheduleController {
    private final MyScheduleService myScheduleService;


    @PostMapping("/makeSchedule")
    public String makeSchedule(String city,String state, Model model)throws URISyntaxException, JsonProcessingException {
        int areaCode = Integer.parseInt(city);
        //기본 콘텐츠타입 12

        List<Map<String, Object>> itemMap = myScheduleService.getData(areaCode, state, 12, 1000);
        model.addAttribute("itemMap", itemMap);
        return "makeSchedule_form";
    }

    @GetMapping("/mySchedule")
    //내가 간 장소들 데려오기
    public String scheduleList(HttpSession session, Model model){
        
        String loginId = (String) session.getAttribute("loginId");
        //로그인 안돼있으면 로그인먼저 하기
        if (loginId == null){
            return "redirect:/login";
        }else{
            List<MySchedule> ScheduleList = myScheduleService.getScheduleList(loginId);
            model.addAttribute("ScheduleList", ScheduleList);
        }
        return "mySchedule_form";
    }

}
