package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.dto.tag.TagDtoView;
import com.salemnabeel.wikicoursesapp.mapper.TagMapper;
import com.salemnabeel.wikicoursesapp.model.Tag;
import com.salemnabeel.wikicoursesapp.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<TagDtoView> getAllTags() {

        List<Tag> tagsList = tagRepository.findAll();

        tagsList.sort((s1, s2) -> s2.getId().compareTo(s1.getId()));

        return TagMapper.entityToDto(tagsList);
    }
}