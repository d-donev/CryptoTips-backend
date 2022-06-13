package com.example.cryptotips.Model.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AnalyzeDTO {

    private String title;

    private String part1;

    private String part2;

    private String part3;

    private String part4;

    private LocalDateTime postedOn;

    public AnalyzeDTO(String title, String part1, String part2, String part3, String part4, LocalDateTime postedOn) {
        this.title = title;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
        this.postedOn = postedOn;
    }
}
