package com.example.yj.mySchedule;

import com.example.yj.entity.MySchedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyScheduleController {
    private final MyScheduleService myScheduleService;

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

    @PostMapping("/makeSchedule")
    public String makeSchedule(Date startDate, String searchBox, String state, Model model){
        model.addAttribute("startDate", startDate);
        model.addAttribute("searchBox", searchBox);
        model.addAttribute("state", state);
        return "makeSchedule_form";
    }
}
