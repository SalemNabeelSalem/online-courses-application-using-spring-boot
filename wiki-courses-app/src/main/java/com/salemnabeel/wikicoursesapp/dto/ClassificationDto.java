package com.salemnabeel.wikicoursesapp.dto;

import lombok.Data;

@Data
public class ClassificationDto {

    private Long id;

    private String title;

    private SectionDto section;

    private Boolean isActive;
}