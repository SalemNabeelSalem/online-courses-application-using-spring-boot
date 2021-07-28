package com.salemnabeel.wikicoursesapp.model;

import com.salemnabeel.wikicoursesapp.model.enums.Gender;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
    @Size(max = 25, min = 2)
    @Column(name = "full_name", length = 25, unique = true, nullable = false)
    private String fullName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 1, nullable = false)
    private Gender gender;

    @NotNull
    @Size(max = 500, min = 2)
    @Column(length = 500, nullable = false)
    private String description;

    @Email
    @NotNull
    @Size(max = 50, min = 2)
    @Column(length = 50, unique = true, nullable = false)
    private String email;

    @NotNull
    @Size(max = 255, min = 2)
    @Column(name = "profile_image_link", length = 255, nullable = false)
    private String profileImageLink;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}