package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.dto.ContactUs.ContactUsDtoNew;
import com.salemnabeel.wikicoursesapp.dto.ContactUs.ImprovedFaqAnswer;
import com.salemnabeel.wikicoursesapp.model.ContactUs;
import com.salemnabeel.wikicoursesapp.repository.ContactUsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactUsService {

    @Autowired
    private ContactUsRepository contactUsRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ContactUsDtoNew createNewContactUsMessage(ContactUsDtoNew contactUsDtoNew) {

        ContactUs contactUs = new ContactUs();

        contactUs.setName(contactUsDtoNew.getName());

        contactUs.setEmail(contactUsDtoNew.getEmail());

        contactUs.setMessage(contactUsDtoNew.getMessage());

        contactUs.setMessageAnswer("not answer it yet.");

        contactUs.setIsPublish(false);

        contactUsRepository.save(contactUs);

        return this.modelMapper.map(contactUsRepository.save(contactUs), ContactUsDtoNew.class);
    }

    public List<ImprovedFaqAnswer> getAllImprovedFaqAnswers() {

        List<ImprovedFaqAnswer> improvedFaqAnswers = contactUsRepository.getAllImprovedFaqAnswers().stream()
            .sorted((s1, s2) -> s2.getId().compareTo(s1.getId()))
            .map(obj1 -> this.modelMapper.map(obj1, ImprovedFaqAnswer.class)
        ).collect(Collectors.toList());

    return improvedFaqAnswers;
    }
}