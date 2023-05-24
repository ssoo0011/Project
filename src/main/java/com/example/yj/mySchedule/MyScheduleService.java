package com.example.yj.mySchedule;

import com.example.yj.entity.MySchedule;
import com.example.yj.entity.Post;
import com.example.yj.repository.MyScheduleRepository;
import com.example.yj.repository.PostRepository;
import com.example.yj.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MyScheduleService {
    private final MyScheduleRepository myScheduleRepository;

    // 세션에 저장된 아이디 유저가 방문한 장소들 모두 들고오기
    public List<MySchedule> getScheduleList(String loginId){
        //로그인한 아이디로 스케쥴 들고오기
        List<MySchedule> ScheduleList  = myScheduleRepository.findByUserId(loginId);
        return ScheduleList;
    }

    public void getSpotList(){

    }
}
