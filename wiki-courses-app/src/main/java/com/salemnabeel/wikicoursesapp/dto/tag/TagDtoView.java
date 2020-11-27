package com.salemnabeel.wikicoursesapp.dto.tag;

import lombok.Data;

import java.util.Date;

@Data
public class TagDtoView {

    private Long id;

    private String title;

    private Date createdAt;

    private Date updatedAt;

    private Boolean isActive;
}