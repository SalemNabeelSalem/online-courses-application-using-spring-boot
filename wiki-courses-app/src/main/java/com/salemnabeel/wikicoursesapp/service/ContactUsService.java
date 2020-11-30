package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.dto.ContactUs.ContactUsDtoNew;
import com.salemnabeel.wikicoursesapp.dto.ContactUs.ContactUsDtoView;
import com.salemnabeel.wikicoursesapp.model.ContactUs;
import com.salemnabeel.wikicoursesapp.repository.ContactUsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactUsService {

    @Autowired
    private ContactUsRepository contactUsRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ContactUsDtoView createNewContactUsMessage(ContactUsDtoNew contactUsDtoNew) {

        ContactUs contactUs = new ContactUs();

        contactUs.setName(contactUsDtoNew.getName());

        contactUs.setEmail(contactUsDtoNew.getEmail());

        contactUs.setMessage(contactUsDtoNew.getMessage());

        contactUs.setMessageAnswer("not answer it yet.");

        contactUs.setIsReaded(false);

        contactUsRepository.save(contactUs);

        ContactUsDtoView contactUsDtoView = this.modelMapper.map(
            contactUsRepository.save(contactUs), ContactUsDtoView.class
        );

        return contactUsDtoView;
    }
}