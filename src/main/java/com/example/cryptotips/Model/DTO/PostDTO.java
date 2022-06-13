package com.example.cryptotips.Model.DTO;

import lombok.Data;

@Data
public class PostDTO {

    private String title;

    private String description;

    private String image;

    public PostDTO(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }
}
