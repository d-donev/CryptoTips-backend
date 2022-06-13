package com.example.cryptotips.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Analyze {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String part1;

    private String part2;

    private String part3;

    private String part4;

    private LocalDateTime postedOn;

    public Analyze() {
    }

    public Analyze(String title, String part1, String part2, String part3, String part4) {
        this.title = title;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
        this.postedOn = LocalDateTime.now();
    }
}
