package com.salemnabeel.wikicoursesapp.dto.view;

import com.salemnabeel.wikicoursesapp.model.enums.Language;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CourseDto {

    private Long id;

    private String title;

    private String sourceUrl;

    private String section;

    private String classification;

    private String description;

    private String coverImageLink;

    private String lecturer;

    private Language language;

    private Date createdDate;

    private List<TagDto> tags;
}