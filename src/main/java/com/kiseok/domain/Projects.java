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
public class Projects implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idx;

    @Column
    private String name;

    @Column
    private String period;

    @Column
    private String persons;

    @Column
    private String description;

    @Column
    private LocalDateTime registeredDate;

    @Builder
    public Projects(String name, String period, String persons, String description, LocalDateTime registeredDate) {
        this.name = name;
        this.period = period;
        this.persons = persons;
        this.description = description;
        this.registeredDate = registeredDate;
    }
}
