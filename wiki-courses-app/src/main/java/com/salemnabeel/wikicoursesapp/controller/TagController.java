package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.dto.section.SectionDtoView;
import com.salemnabeel.wikicoursesapp.dto.tag.TagDtoView;
import com.salemnabeel.wikicoursesapp.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/all-tags")
    public List<TagDtoView> getAllTags() {

        return tagService.getAllTags();
    }
}