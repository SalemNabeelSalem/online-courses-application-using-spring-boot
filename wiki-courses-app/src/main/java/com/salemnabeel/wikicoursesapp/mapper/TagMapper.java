package com.salemnabeel.wikicoursesapp.mapper;

import com.salemnabeel.wikicoursesapp.dto.view.TagDto;
import com.salemnabeel.wikicoursesapp.model.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TagMapper {

    public TagDto entityToDto(Tag tag) {

        ModelMapper modelMapper = new ModelMapper();

        TagDto tagDto = modelMapper.map(tag, TagDto.class);

        return tagDto;
    }

    public List<TagDto> entityToDto(List<Tag> tagsList) {

        return tagsList.stream().map(
            tag -> entityToDto(tag)
        ).collect(Collectors.toList());
    }

    public Tag dtoToEntity(TagDto tagDto) {

        ModelMapper modelMapper = new ModelMapper();

        Tag tag = modelMapper.map(tagDto, Tag.class);

        return tag;
    }

    public List<Tag> dtoToEntity(List<TagDto> tagsDtoList) {

        return tagsDtoList.stream().map(
            tagDto -> dtoToEntity(tagDto)
        ).collect(Collectors.toList());
    }
}