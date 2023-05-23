package com.example.yj.login;

import com.example.yj.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
//@RestController
public class LogInController {

    private final LogInService logInService;
    @GetMapping("/login")
    public String logInPage(){
        return "login_form";
    }

    @PostMapping("/login/user")
    public String userConfirm(String userId, String userPw, HttpSession session){
        
        if(logInService.userLoginConfirm(userId, userPw)){
            
            session.setAttribute("loginId", userId); // 로그인한 아이디 세션 저장
            session.setAttribute("userType", "user"); // 로그인한 유저타입 세션 저장
            return "redirect:/home/";
        }
        return "login_form";
    }
    @PostMapping("/login/owner")
    public String ownerConfirm(String userId, String userPw, HttpSession session){
        if(logInService.ownerLoginConfirm(userId, userPw)){
            session.setAttribute("loginId", userId);
            session.setAttribute("userType", "owner");
            return "home_form";
        }
        return "login_form";
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session){//로그아웃
        session.removeAttribute("loginId");
        session.removeAttribute("userType");
        return "redirect:/home/";

    }

}
