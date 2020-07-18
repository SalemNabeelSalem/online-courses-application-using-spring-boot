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
    @Size(max = 255)
    @Column(unique = true, nullable = false, length = 255)
    private String title;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}