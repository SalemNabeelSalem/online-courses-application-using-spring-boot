package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.repository.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactUsService {

    @Autowired
    private ContactUsRepository contactUsRepository;
}