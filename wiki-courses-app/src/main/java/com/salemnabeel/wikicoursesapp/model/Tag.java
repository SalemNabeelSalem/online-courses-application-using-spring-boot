package com.salemnabeel.wikicoursesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "tags")
@NoArgsConstructor
@AllArgsConstructor
public class Tag extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 45, min = 2)
    @Column(length = 45, nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}