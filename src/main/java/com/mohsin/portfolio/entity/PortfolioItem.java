package com.mohsin.portfolio.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "portfolio_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortfolioItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* ===== Personal Info ===== */
    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String contactNumber;

    private String email;
    private String location;

    /* ===== Professional Info ===== */
    private String currentJobProfile;

    @Column(columnDefinition = "TEXT")
    private String bio;

    private String profileImageUrl;

    /* ===== Skills ===== */
    @ElementCollection
    @CollectionTable(
            name = "portfolio_skills",
            joinColumns = @JoinColumn(name = "portfolio_id")
    )
    @Column(name = "skill")
    private List<String> skills;

    /* ===== Projects (NEW RELATION) ===== */
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "portfolio_id")
    private List<Project> projects;

    /* ===== Profile Links ===== */
    private String githubUrl;
    private String linkedinUrl;
    private String portfolioUrl;
}
