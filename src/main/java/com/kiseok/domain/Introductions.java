package com.kiseok.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Introductions implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idx;

    @Column
    private String title;

    //성장배경
    @Column
    private String growth;
    //지원동기
    @Column
    private String reason;

    //장점
    @Column
    private String strength;

    //단점
    @Column
    private String weakness;

    //입사 후 포부
    @Column
    private String aspiration;

    @Column
    private LocalDateTime registeredDate;


    @Builder
    public Introductions(String title, String growth, String reason, String strength, String weakness, String aspiration, LocalDateTime registeredDate) {
        this.title = title;
        this.growth = growth;
        this.reason = reason;
        this.strength = strength;
        this.weakness = weakness;
        this.aspiration = aspiration;
        this.registeredDate = registeredDate;
    }

    public void setRegisteredDateNow()  {
        this.registeredDate = LocalDateTime.now();
    }

}
