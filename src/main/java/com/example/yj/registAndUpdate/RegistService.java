package com.example.yj.registAndUpdate;

import com.example.yj.DataNotFoundException;
import com.example.yj.entity.Owner;
import com.example.yj.entity.User;
import com.example.yj.repository.OwnerRepository;
import com.example.yj.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistService {

    private final UserRepository userRepository;
    private final OwnerRepository ownerRepository;

    public void RegistUser(User user, String year, String month, String day) {

        String userBirth = String.format("%s-%s-%s", year, month, day); //생년월일 포멧
        java.sql.Date d = java.sql.Date.valueOf(userBirth);

        User u = User.builder()
                .userName(user.getUserName())
                .userId(user.getUserId())
                .userPw(user.getUserPw())
                .birth(d)
                .build();

        userRepository.save(u);
    }

    public void RegistOwner(Owner owner) {

        Owner bsm = Owner.builder()
                .userName(owner.getUserName())
                .userId(owner.getUserId())
                .userPw(owner.getUserPw())
                .build();

        ownerRepository.save(bsm);
    }

    public int idCheck(String id) { //아이디 중복체크
        Optional<Owner> r1 = ownerRepository.findById(id);
        Optional<User> r2 = userRepository.findById(id);
        //아이디가 있으면 1, 없으면 0 리턴
        int cnt = r1.isPresent() || r2.isPresent()? 1 : 0;
        System.out.println(cnt + "서비스");
        
        return cnt; //컨트롤러 -> ajax로 보내줄 값
    }


}
