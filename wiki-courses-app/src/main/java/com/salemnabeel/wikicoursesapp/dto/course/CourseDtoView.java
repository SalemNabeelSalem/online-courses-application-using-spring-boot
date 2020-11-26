package com.salemnabeel.wikicoursesapp.dto.course;

import com.salemnabeel.wikicoursesapp.model.enums.Language;
import lombok.Data;

import java.util.Date;

@Data
public class CourseDtoView {

    private Long id;

    private String title;

    private String sourceUrl;

    private String description;

    private String classificationTitle;

    private String classificationSectionTitle;

    private String coverImageLink;

    private String lecturerFullName;

    private Language language;

    private Date createdAt;

    private Date updatedAt;

    private Boolean isActive;
}