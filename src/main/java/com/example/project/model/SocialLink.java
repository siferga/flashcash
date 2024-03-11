package com.example.project.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SocialLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private User user1;
    @ManyToOne
    private User user2;

}
