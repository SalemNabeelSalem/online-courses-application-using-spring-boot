package com.salemnabeel.wikicoursesapp.dto;

import lombok.Data;

@Data
public class CourseDto {

    private Long id;

    private String title;

    private String sourceUrl;

    private String description;

    private Boolean isActive;
}