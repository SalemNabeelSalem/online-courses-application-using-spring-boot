package com.salemnabeel.wikicoursesapp.mapper.section;

import com.salemnabeel.wikicoursesapp.dto.section.SectionDto;
import com.salemnabeel.wikicoursesapp.model.Section;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class SectionMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static SectionDto entityToDto(Section section) {

        // SectionDto sectionDto = new SectionDto();

        // sectionDto.setId(section.getId());

        // sectionDto.setTitle(section.getTitle());

        // sectionDto.setCoverImageLink(section.getCoverImageLink());

        SectionDto sectionDto = modelMapper.map(section, SectionDto.class);

        return sectionDto;
    }

    public static List<SectionDto> entityToDto(List<Section> sectionsList) {

        return sectionsList.stream().map(section -> entityToDto(section)).collect(Collectors.toList());
    }

    public static Section dtoToEntity(SectionDto sectionDto) {

        // Section section = new Section();

        // section.setId(sectionDto.getId());

        // section.setTitle(sectionDto.getTitle());

        // section.setCoverImageLink(sectionDto.getCoverImageLink());

        Section section = modelMapper.map(sectionDto, Section.class);

        return section;
    }

    public static List<Section> dtoToEntity(List<SectionDto> sectionsDtoList) {

        return sectionsDtoList.stream().map(
            sectionDto -> dtoToEntity(sectionDto)
        ).collect(Collectors.toList());
    }
}