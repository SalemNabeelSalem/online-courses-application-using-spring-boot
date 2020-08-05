package com.salemnabeel.wikicoursesapp.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CourseDto {

    private Long id;

    private String title;

    private String sourceUrl;

    private String description;

    private String classification;

    private String section;

    private String lecturer;

    private Date createdAtDate;
}