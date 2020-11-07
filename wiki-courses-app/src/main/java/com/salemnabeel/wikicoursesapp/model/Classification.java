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
@Table(name = "classifications")
public class Classification extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 20, min = 2)
    @Column(length = 20, unique = true, nullable = false)
    private String title;

    @NotNull
    @Size(max = 255, min = 2)
    @Column(nullable = false)
    private String brief;

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "section_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Section section;

    @NotNull
    @Size(max = 255, min = 2)
    @Column(name = "cover_image_link", length = 255, nullable = false)
    private String coverImageLink;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}