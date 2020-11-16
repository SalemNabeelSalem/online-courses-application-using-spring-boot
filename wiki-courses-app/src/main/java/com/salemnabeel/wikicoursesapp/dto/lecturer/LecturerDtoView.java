package com.salemnabeel.wikicoursesapp.dto.lecturer;

import lombok.Data;

import java.util.Date;

@Data
public class LecturerDtoView {

    private Long id;

    private String fullName;

    private String email;

    private String profileImageLink;

    private Date createdAt;

    private Date updatedAt;

    private Boolean isActive;
}