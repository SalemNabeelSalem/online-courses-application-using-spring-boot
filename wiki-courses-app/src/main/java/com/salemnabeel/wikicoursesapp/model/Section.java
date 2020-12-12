package com.salemnabeel.wikicoursesapp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "sections")
public class Section extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 40, min = 2)
    @Column(length = 40, unique = true, nullable = false)
    private String title;

    @NotNull
    @Size(max = 255, min = 2)
    @Column(nullable = false)
    private String brief;

    @NotNull
    @Size(max = 255, min = 2)
    @Column(name = "cover_image_link", nullable = false)
    private String coverImageLink;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}