package com.salemnabeel.wikicoursesapp.dto.section;

import lombok.Data;

import java.util.Date;

@Data
public class SectionDto {

    private Long id;

    private String title;

    private String brief;

    private String coverImageLink;

    private Date createdAt;

    private Date updatedAt;

    private Boolean isActive;
}