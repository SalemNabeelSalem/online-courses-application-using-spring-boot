package com.salemnabeel.wikicoursesapp.mapper;

import com.salemnabeel.wikicoursesapp.dto.tag.TagDtoView;
import com.salemnabeel.wikicoursesapp.model.Tag;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class TagMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static TagDtoView entityToDto(Tag tag) {

        ModelMapper modelMapper = new ModelMapper();

        TagDtoView tagDtoView = modelMapper.map(tag, TagDtoView.class);

        return tagDtoView;
    }

    public static List<TagDtoView> entityToDto(List<Tag> tagsList) {

        return tagsList.stream().map(
            obj -> entityToDto(obj)
        ).collect(Collectors.toList());
    }

    public static Tag dtoToEntity(TagDtoView tagDtoView) {

        ModelMapper modelMapper = new ModelMapper();

        Tag tag = modelMapper.map(tagDtoView, Tag.class);

        return tag;
    }

    public static List<Tag> dtoToEntity(List<TagDtoView> tagsDtoList) {

        return tagsDtoList.stream().map(
            obj -> dtoToEntity(obj)
        ).collect(Collectors.toList());
    }
}