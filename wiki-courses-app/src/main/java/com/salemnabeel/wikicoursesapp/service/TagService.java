package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.dto.tag.TagDtoNew;
import com.salemnabeel.wikicoursesapp.dto.tag.TagDtoView;
import com.salemnabeel.wikicoursesapp.exception.ResourceNotFoundException;
import com.salemnabeel.wikicoursesapp.mapper.TagMapper;
import com.salemnabeel.wikicoursesapp.model.Course;
import com.salemnabeel.wikicoursesapp.model.Tag;
import com.salemnabeel.wikicoursesapp.repository.CourseRepository;
import com.salemnabeel.wikicoursesapp.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<TagDtoView> getAllTags() {

        List<Tag> tagsList = tagRepository.findAll();

        tagsList.sort((s1, s2) -> s2.getId().compareTo(s1.getId()));

        return TagMapper.entityToDto(tagsList);
    }

    public List<TagDtoView> getAllActiveTags() {

        List<Tag> tagsList = tagRepository.getAllActiveTags();

        tagsList.sort((s1, s2) -> s2.getId().compareTo(s1.getId()));

        return TagMapper.entityToDto(tagsList);
    }

    public TagDtoView createNewTag(TagDtoNew tagDtoNew) {

        Long courseId = tagDtoNew.getCourseId();

        if (courseRepository.findById(courseId).isEmpty()) {

            throw new ResourceNotFoundException("course resource not found.");
        }

        Course course = courseRepository.findById(courseId).get();

        Tag tag = new Tag();

        tag.setTitle(tagDtoNew.getTitle());

        tag.setCourse(course);

        tag.setIsActive(true);

        return TagMapper.entityToDto(tagRepository.save(tag));
    }
}