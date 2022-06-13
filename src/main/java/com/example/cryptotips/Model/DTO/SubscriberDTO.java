package com.example.cryptotips.Model.DTO;

import lombok.Data;

@Data
public class SubscriberDTO {

    private String username;

    public SubscriberDTO(String username) {
        this.username = username;
    }
}
