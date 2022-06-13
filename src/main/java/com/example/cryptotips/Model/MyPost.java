package com.example.cryptotips.Model;

import lombok.Data;
import org.attoparser.dom.Text;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class MyPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;

    private String description;

    private String image;

    private LocalDateTime dateAdded;

    public MyPost() {
    }

    public MyPost(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.dateAdded = LocalDateTime.now();
    }
}
