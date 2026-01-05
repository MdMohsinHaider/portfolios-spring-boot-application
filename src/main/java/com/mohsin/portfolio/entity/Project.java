package com.mohsin.portfolio.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String techStack;

    private String projectUrl;

    private String imageUrl;
}
