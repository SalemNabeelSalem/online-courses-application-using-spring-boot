package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.dto.tag.TagDtoNew;
import com.salemnabeel.wikicoursesapp.dto.tag.TagDtoView;
import com.salemnabeel.wikicoursesapp.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/active-tags")
    public List<TagDtoView> getAllActiveTags() {

        return tagService.getAllActiveTags();
    }

    @PostMapping("/add-tag")
    public TagDtoView createNewTag(@Valid @RequestBody TagDtoNew sectionDtoNewRequest) {

        return tagService.createNewTag(sectionDtoNewRequest);
    }
}