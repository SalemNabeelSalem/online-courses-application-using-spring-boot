package com.salemnabeel.wikicoursesapp.dto.ContactUs;

import lombok.Data;

@Data
public class ContactUsDtoView {

    private Long id;

    private String name;

    private String email;

    private String message;

    private String messageAnswer;

    private Boolean isReaded;
}