package com.salemnabeel.wikicoursesapp.dto.lecturer;

import com.salemnabeel.wikicoursesapp.model.enums.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class LecturerDtoView {

    private Long id;

    private String fullName;

    private Gender gender;

    private String description;

    private String email;

    private String profileImageLink;

    private Date createdAt;

    private Date updatedAt;

    private Boolean isActive;
}