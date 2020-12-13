package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.dto.Faq.FaqDtoNew;
import com.salemnabeel.wikicoursesapp.dto.Faq.ImprovedFaqAnswer;
import com.salemnabeel.wikicoursesapp.model.Faq;
import com.salemnabeel.wikicoursesapp.repository.FaqRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FaqService {

    @Autowired
    private FaqRepository faqRepository;

    @Autowired
    private ModelMapper modelMapper;

    public FaqDtoNew createNewFaq(FaqDtoNew faqDtoNew) {

        Faq faq = new Faq();

        faq.setName(faqDtoNew.getName());

        faq.setEmail(faqDtoNew.getEmail());

        faq.setMessage(faqDtoNew.getMessage());

        faq.setMessageAnswer("this question not answer it yet.");

        faq.setIsPublish(false);

        faqRepository.save(faq);

        return this.modelMapper.map(faqRepository.save(faq), FaqDtoNew.class);
    }

    public List<ImprovedFaqAnswer> getAllImprovedFaqAnswers() {

        List<ImprovedFaqAnswer> improvedFaqAnswers = faqRepository.getAllImprovedFaqAnswers().stream()
            .sorted((s1, s2) -> s2.getId().compareTo(s1.getId()))
            .map(obj1 -> this.modelMapper.map(obj1, ImprovedFaqAnswer.class)
        ).collect(Collectors.toList());

    return improvedFaqAnswers;
    }
}