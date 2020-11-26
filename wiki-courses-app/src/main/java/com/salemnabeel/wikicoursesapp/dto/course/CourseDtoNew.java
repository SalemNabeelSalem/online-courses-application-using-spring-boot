package com.salemnabeel.wikicoursesapp.dto.course;

import com.salemnabeel.wikicoursesapp.model.enums.Language;
import lombok.Data;

@Data
public class CourseDtoNew {

    private String title;

    private String sourceUrl;

    private Long classificationId;

    private String description;

    private String coverImageLink;

    private Long lecturerId;

    private Language language;
}
