package com.example.cryptotips.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime validFrom;

    private String username;

    public Subscriber() {
    }

    public Subscriber(String username) {
        this.validFrom = LocalDateTime.now();
        this.username = username;
    }
}
