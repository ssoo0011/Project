package com.example.yj;

import com.example.yj.PopularSpot.PopulaSpotService;
import com.example.yj.entity.Post;
import com.example.yj.entity.TouristSpot;
import com.example.yj.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final PostService postService;
    @GetMapping("/")
    public String goHome(Model model){

        List<String> popSpotList = postService.popularSpot(); // 인기 장소 리스트 불러오기
        List<Post> popPostList = postService.popularPost(); // 인기 게시글 리스트 불러오기
        model.addAttribute("popSpotList", popSpotList);
        model.addAttribute("popPostList", popPostList);

        return "home_form";
    }




}
