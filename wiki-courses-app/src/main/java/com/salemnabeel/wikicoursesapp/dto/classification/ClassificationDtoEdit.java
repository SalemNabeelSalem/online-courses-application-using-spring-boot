package com.salemnabeel.wikicoursesapp.dto.classification;

import lombok.Data;

@Data
public class ClassificationDtoEdit {

    private String title;

    private String brief;

    private Long sectionId;

    private String coverImageLink;

    private Boolean isActive;
}