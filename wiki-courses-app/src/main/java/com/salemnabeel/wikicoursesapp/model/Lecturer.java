package com.salemnabeel.wikicoursesapp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "lecturers")
public class Lecturer extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255, min = 1)
    @Column(name = "full_name", length = 255, unique = true, nullable = false)
    private String fullName;

    @NotNull
    @Size(max = 255, min = 1)
    @Column(length = 255, unique = true, nullable = false)
    private String email;

    // TODO: Creating The imageUrl Property For Storing The Image Profile Of Lecturer.

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}