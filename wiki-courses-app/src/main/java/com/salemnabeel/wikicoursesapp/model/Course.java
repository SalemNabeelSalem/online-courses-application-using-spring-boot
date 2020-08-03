package com.salemnabeel.wikicoursesapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @Size(max = 255, min = 1)
    @Column(length = 255, unique = true, nullable = false)
    private String title;

    @NotNull
    @Size(max = 255, min = 1)
    @Column(name = "source_url", length = 255, unique = true, nullable = false)
    private String sourceUrl;

    // TODO: Creating The classificationId Property For Relationship With The Classification Table.

    @NotNull
    @Size(max = 255, min = 1)
    @Column(length = 255, nullable = false)
    private String description;

    // TODO: Creating The coverImageUrl Property For Storing The Cover Image Of The Course.

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "lecturer_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Lecturer lecturer;

    // TODO: Creating The language Property For Storing The Language Type Of The Course.

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}