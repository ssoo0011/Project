package com.example.yj.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "MySchedule") //테이블 이름
public class MySchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId; //스케쥴 번호
    @Column(nullable = false)
    private String spot; // 방문지역
    @CreatedDate
    private LocalDate date; //방문 날짜
    @Column(nullable = false)
    private String userId; // 아이디 가진사람

}
