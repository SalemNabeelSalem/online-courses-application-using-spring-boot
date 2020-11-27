package com.salemnabeel.wikicoursesapp.dto.tag;

import lombok.Data;

@Data
public class TagDtoEdit {

    private String title;

    private Long courseId;

    private Boolean isActive;
}