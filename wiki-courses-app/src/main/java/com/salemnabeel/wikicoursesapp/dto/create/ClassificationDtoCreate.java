package com.salemnabeel.wikicoursesapp.dto.create;

import lombok.Data;

@Data
public class ClassificationDtoCreate {

    private String title;

    private Long sectionId;

    private String coverImageLink;
}