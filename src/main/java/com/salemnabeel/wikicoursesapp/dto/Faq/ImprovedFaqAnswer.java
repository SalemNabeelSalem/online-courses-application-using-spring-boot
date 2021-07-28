package com.salemnabeel.wikicoursesapp.dto.Faq;

import lombok.Data;

import java.util.Date;

@Data
public class ImprovedFaqAnswer {

    private Long id;

    private String name;

    private String message;

    private String messageAnswer;

    private Date createdAt;
}