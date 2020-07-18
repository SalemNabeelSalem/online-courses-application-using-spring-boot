package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.model.Section;
import com.salemnabeel.wikicoursesapp.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    public List<Section> getAllActiveSections() {

        return sectionRepository.getAllActiveSections();
    }

    public Section createNewSection(Section section) {

        return sectionRepository.save(section);
    }
}