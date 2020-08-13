package com.salemnabeel.wikicoursesapp.mapper;

import com.salemnabeel.wikicoursesapp.dto.view.ClassificationDto;
import com.salemnabeel.wikicoursesapp.model.Classification;
import com.salemnabeel.wikicoursesapp.model.Section;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClassificationMapper {

    public ClassificationDto entityToDto(Classification classification) {

        // ModelMapper modelMapper = new ModelMapper();

        // ClassificationDTO classificationDto = modelMapper.map(classification, classificationDto.class);

        ClassificationDto classificationDto = new ClassificationDto();

        // For Classification Id
        classificationDto.setId(classification.getId());

        // For Classification Title
        classificationDto.setTitle(classification.getTitle());

        Section section = classification.getSection();

        // For Section Title
        classificationDto.setSectionTitle(section.getTitle());

        // For Classification Cover Image Link
        classificationDto.setCoverImageLink(classification.getCoverImageLink());

        return classificationDto;
    }

    public List<ClassificationDto> entityToDto(List<Classification> classificationsList) {

        return classificationsList.stream().map(
            classification -> entityToDto(classification)
        ).collect(Collectors.toList());
    }

    public Classification dtoToEntity(ClassificationDto classificationDto) {

        // Classification classification = new Classification();

        // classification.setId(classificationDto.getId());

        // classification.setTitle(classificationDto.getTitle());

        // classification.setCoverImageLink(classificationDto.getCoverImageLink());

        ModelMapper modelMapper = new ModelMapper();

        Classification classification = modelMapper.map(classificationDto, Classification.class);

        return classification;
    }

    public List<Classification> dtoToEntity(List<ClassificationDto> classificationsDtoList) {
        return classificationsDtoList.stream().map(
            classificationDto -> dtoToEntity(classificationDto)
        ).collect(Collectors.toList());
    }
}