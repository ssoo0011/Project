package com.example.yj.information;

import com.example.yj.entity.Owner;
import com.example.yj.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class InformationController {
    private final InformationService informationService;

    @GetMapping("/userInfor")
    //유저 정보 불러오기 메소드
    public String userInformation(HttpSession session, Model model){

        String userId = (String)session.getAttribute("loginId"); //로그인 한 아이디
        String userType = (String)session.getAttribute("userType"); //로그인한 사람의 유저타입 (user || owner)

        if (userType.equals("user")){

            User user = informationService.userInformation(userId);
            model.addAttribute("user", user);
            return "userInformation_form";

        }else if (userType.equals("owner")){
            Owner owner = informationService.ownerInformation(userId);
            model.addAttribute("owner", owner);
        }
        return "ownerInformation_form";

    }

    @PostMapping("/updateInfor")
    public String updateInformation(HttpSession session, String userPw){

        String userId = (String)session.getAttribute("loginId");
        String userType = (String)session.getAttribute("userType");

        if (userType.equals("user")){
            informationService.updateUser(userId, userPw);

        }else if (userType.equals("owner")){
            informationService.updateOwner(userId, userPw);
        }
        return "redirect:/home/";
    }
}