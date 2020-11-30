package com.salemnabeel.wikicoursesapp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "contact_us")
public class ContactUs extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotNull
    @Size(max = 50, min = 2)
    @Column(length = 50, unique = true, nullable = false)
    private String email;

    @NotNull
    @Size(max = 500, min = 2)
    @Column(length = 500, nullable = false)
    private String message;

    @Size(max = 500, min = 2)
    @Column(name = "message_answer", length = 500, nullable = false)
    private String messageAnswer;

    @Column(name = "is_readed", nullable = false)
    private Boolean isReaded;
}
