package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.dto.view.TagDto;
import com.salemnabeel.wikicoursesapp.mapper.TagMapper;
import com.salemnabeel.wikicoursesapp.model.Tag;
import com.salemnabeel.wikicoursesapp.repository.CourseRepository;
import com.salemnabeel.wikicoursesapp.repository.TagRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TagMapper tagMapper;

    public void createNewTagByCourseId(Long courseId, List<Tag> tagRequest) {

        List<Tag> tags = tagRequest;

        System.out.print(tags);

        // tag.setCourse(courseRepository.findById(courseId).get());

        // return tagMapper.entityToDto(tagRepository.save(tagRequest));
    }
}