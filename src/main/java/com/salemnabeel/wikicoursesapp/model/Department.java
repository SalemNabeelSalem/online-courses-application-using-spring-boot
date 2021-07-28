package com.salemnabeel.wikicoursesapp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "departments")
public class Department extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 20, min = 2)
    @Column(length = 20, unique = true, nullable = false)
    private String title;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}
