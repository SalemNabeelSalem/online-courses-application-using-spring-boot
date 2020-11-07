package com.salemnabeel.wikicoursesapp.mapper.section;

import com.salemnabeel.wikicoursesapp.dto.section.SectionDtoView;
import com.salemnabeel.wikicoursesapp.model.Section;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class SectionMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static SectionDtoView entityToDto(Section section) {

        // SectionDto sectionDto = new SectionDto();

        // sectionDto.setId(section.getId());

        // sectionDto.setTitle(section.getTitle());

        // sectionDto.setCoverImageLink(section.getCoverImageLink());

        SectionDtoView sectionDtoView = modelMapper.map(section, SectionDtoView.class);

        return sectionDtoView;
    }

    public static List<SectionDtoView> entityToDto(List<Section> sectionsList) {

        return sectionsList.stream().map(section -> entityToDto(section)).collect(Collectors.toList());
    }

    public static Section dtoToEntity(SectionDtoView sectionDtoView) {

        // Section section = new Section();

        // section.setId(sectionDto.getId());

        // section.setTitle(sectionDto.getTitle());

        // section.setCoverImageLink(sectionDto.getCoverImageLink());

        Section section = modelMapper.map(sectionDtoView, Section.class);

        return section;
    }

    public static List<Section> dtoToEntity(List<SectionDtoView> sectionsDtoList) {

        return sectionsDtoList.stream().map(
                sectionDtoView -> dtoToEntity(sectionDtoView)
        ).collect(Collectors.toList());
    }
}