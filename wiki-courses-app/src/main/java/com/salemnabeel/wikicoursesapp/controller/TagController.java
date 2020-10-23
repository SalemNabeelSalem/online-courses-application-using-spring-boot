package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.dto.view.TagDto;
import com.salemnabeel.wikicoursesapp.model.Tag;
import com.salemnabeel.wikicoursesapp.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping("/courses/{course-id}/tags")
    public void createNewTagByCourseId(@PathVariable("course-id") Long courseId,
                                         @Valid @RequestBody List<Tag> tagRequest) {

        tagService.createNewTagByCourseId(courseId, tagRequest);
    }
}