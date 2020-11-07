package com.salemnabeel.wikicoursesapp.dto.classification;

import lombok.Data;

import java.util.Date;

@Data
public class ClassificationDtoView {

    private Long id;

    private String title;

    private String brief;

    private String sectionTitle;

    private String coverImageLink;

    private Date createdAt;

    private Date updatedAt;

    private Boolean isActive;
}