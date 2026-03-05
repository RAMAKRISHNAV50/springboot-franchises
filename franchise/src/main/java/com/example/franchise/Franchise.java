package com.example.franchise;

import jakarta.persistence.*;
import lombok.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Franchise {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String franchiseName;
    private String ownerName;
    private String state;
    private Double networth;
    private String email;
    private String password;
}
