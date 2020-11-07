package com.salemnabeel.wikicoursesapp.mapper.classification;

import com.salemnabeel.wikicoursesapp.dto.classification.ClassificationDtoView;
import com.salemnabeel.wikicoursesapp.model.Classification;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ClassificationMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static ClassificationDtoView entityToDto(Classification classification) {

        // ClassificationDto classificationDto = new ClassificationDto();

        // classificationDto.setId(classification.getId());

        // classificationDto.setTitle(classification.getTitle());

        // Section section = classification.getSection();

        // classificationDto.setSectionTitle(section.getTitle());

        // classificationDto.setCoverImageLink(classification.getCoverImageLink());

        ClassificationDtoView classificationDto = modelMapper.map(classification, ClassificationDtoView.class);

        return classificationDto;
    }

    public static List<ClassificationDtoView> entityToDto(List<Classification> classificationsList) {

        return classificationsList.stream().map(
            classification -> entityToDto(classification)
        ).collect(Collectors.toList());
    }

    public static Classification dtoToEntity(ClassificationDtoView classificationDto) {

        // Classification classification = new Classification();

        // classification.setId(classificationDto.getId());

        // classification.setTitle(classificationDto.getTitle());

        // classification.setCoverImageLink(classificationDto.getCoverImageLink());

        Classification classification = modelMapper.map(classificationDto, Classification.class);

        return classification;
    }

    public static List<Classification> dtoToEntity(List<ClassificationDtoView> classificationsDtoList) {
        return classificationsDtoList.stream().map(
            classificationDto -> dtoToEntity(classificationDto)
        ).collect(Collectors.toList());
    }
}