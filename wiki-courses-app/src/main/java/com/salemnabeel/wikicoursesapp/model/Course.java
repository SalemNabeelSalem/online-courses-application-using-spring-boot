package com.salemnabeel.wikicoursesapp.model;

import com.salemnabeel.wikicoursesapp.model.enums.Language;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "courses")
public class Course extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255, min = 2)
    @Column(unique = true, nullable = false)
    private String title;

    @NotNull
    @Size(max = 255, min = 2)
    @Column(name = "source_url", unique = true, nullable = false)
    private String sourceUrl;

    @ManyToOne
    @JoinColumn(name = "classification_id", nullable = false)
    private Classification classification;

    @NotNull
    @Size(max = 255, min = 2)
    @Column(nullable = false)
    private String description;

    @NotNull
    @Size(max = 255, min = 2)
    @Column(name = "cover_image_link", nullable = false)
    private String coverImageLink;

    @ManyToOne
    @JoinColumn(name = "lecturer_id", nullable = false)
    private Lecturer lecturer;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 2, nullable = false)
    private Language language;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}