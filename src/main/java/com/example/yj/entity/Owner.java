package com.example.yj.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "owner") //테이블 이름

public class Owner {
    @Id
    private String userId; //아이디
    @Column (length = 100, nullable = false)
    private String userPw;
    @Column (length = 30, nullable = false)
    private String userName; //이름


}
