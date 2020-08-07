package com.salemnabeel.wikicoursesapp.dto.view;

import lombok.Data;

@Data
public class LecturerDto {

    private Long id;

    private String fullName;

    private String email;

    private String profileImageLink;
}