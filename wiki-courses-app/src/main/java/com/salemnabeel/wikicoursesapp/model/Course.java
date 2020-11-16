package com.salemnabeel.wikicoursesapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salemnabeel.wikicoursesapp.model.enums.Language;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "courses")
public class Course extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255, min = 2)
    @Column(length = 255, unique = true, nullable = false)
    private String title;

    @NotNull
    @Size(max = 255, min = 2)
    @Column(name = "source_url", length = 255, unique = true, nullable = false)
    private String sourceUrl;

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "classification_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Classification classification;

    @NotNull
    @Size(max = 255, min = 2)
    @Column(nullable = false)
    private String description;

    @NotNull
    @Size(max = 255, min = 2)
    @Column(name = "cover_image_link", length = 255, nullable = false)
    private String coverImageLink;

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "lecturer_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Lecturer lecturer;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 2, nullable = false)
    private Language language;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @JsonIgnore
    @OneToMany(
        mappedBy = "course",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL
    )
    private List<Tag> tags;
}