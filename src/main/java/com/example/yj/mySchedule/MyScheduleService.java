package com.example.yj.mySchedule;

import com.example.yj.entity.MySchedule;
import com.example.yj.entity.Post;
import com.example.yj.repository.MyScheduleRepository;
import com.example.yj.repository.PostRepository;
import com.example.yj.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

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

    public List<Map<String, Object>> getData(int areaCode, String state, int contentTypeId, int numOfRows) throws URISyntaxException, JsonProcessingException {

        String link = "https://apis.data.go.kr/B551011/KorService1/areaBasedList1";
        String MobileOS = "ETC";
        String MobileApp = "Test";
        String _type = "json";
        String serviceKey = "T1qovE9jf%2Fyn9yPmKA3bvC9UCxaoltyuI7sINKHf7kNL998daoN4zMCih29CPpG%2FATacLQ4%2FIAgo0klJBWxXVQ%3D%3D";

        String url = link + "?" +
                "&MobileOS=" + MobileOS +
                "&MobileApp=" + MobileApp +
                "&_type=" + _type +
                "&areaCode=" + areaCode +
                "&contentTypeId=" + contentTypeId +
                "&numOfRows=" + numOfRows +
                "&serviceKey=" + serviceKey;

        URI uri = new URI(url);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        String response = restTemplate.getForObject(
                uri,
                String.class
        );

        Map<String, Object> map = new ObjectMapper().readValue(response.toString(), Map.class);
        Map<String, Object> responseMap = (Map<String, Object>) map.get("response");
        Map<String, Object> bodyMap = (Map<String, Object>) responseMap.get("body");
        Map<String, Object> itemsMap = (Map<String, Object>) bodyMap.get("items");
        List<Map<String, Object>> itemMap = (List<Map<String, Object>>) itemsMap.get("item");

        //state에 있는 정보만 들고오기
        List<Map<String, Object>> testItemMap = itemMap.stream()
                .filter(item -> {
                    Object value = item.get("addr1");
                    return value != null && value.toString().contains(state);
                })
                .collect(Collectors.toList());


        return testItemMap;
    }
}
