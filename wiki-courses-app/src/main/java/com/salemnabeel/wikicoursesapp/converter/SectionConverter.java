package com.salemnabeel.wikicoursesapp.converter;

import com.salemnabeel.wikicoursesapp.dto.SectionDto;
import com.salemnabeel.wikicoursesapp.model.Section;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SectionConverter {

    public SectionDto entityToDto(Section section) {

        // SectionDto sectionDto = new SectionDto();

        // sectionDto.setId(section.getId());

        // sectionDto.setTitle(section.getTitle());

        // sectionDto.setIsActive(section.getIsActive());

        ModelMapper modelMapper = new ModelMapper();

        SectionDto sectionDto = modelMapper.map(section, SectionDto.class);

        return sectionDto;
    }

    public List<SectionDto> entityToDto(List<Section> sectionsList) {

        return sectionsList.stream().map(
            section -> entityToDto(section)).collect(Collectors.toList()
        );
    }

    public Section dtoToEntity(SectionDto sectionDto) {

        // Section section = new Section();

        // section.setId(sectionDto.getId());

        // section.setTitle(sectionDto.getTitle());

        // section.setIsActive(sectionDto.getIsActive());

        ModelMapper modelMapper = new ModelMapper();

        Section section = modelMapper.map(sectionDto, Section.class);

        return section;
    }

    public List<Section> dtoToEntity(List<SectionDto> sectionsDtoList) {

        return sectionsDtoList.stream().map(
            sectionDto -> dtoToEntity(sectionDto)).collect(Collectors.toList()
        );
    }
}