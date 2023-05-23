package com.example.yj.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "touristSpot") //테이블 이름
public class TouristSpot {

    @Id
    private String tourSpot; //관광지
    @Column
    private String area; // 지역
    @Column
    private Long visitNum; //방문횟수

}
