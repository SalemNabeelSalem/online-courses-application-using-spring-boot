package com.salemnabeel.wikicoursesapp.mapper;

import com.salemnabeel.wikicoursesapp.dto.classification.ClassificationDtoView;
import com.salemnabeel.wikicoursesapp.model.Classification;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ClassificationMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static ClassificationDtoView entityToDto(Classification classification) {

        ClassificationDtoView classificationDto = modelMapper.map(classification, ClassificationDtoView.class);

        return classificationDto;
    }

    public static List<ClassificationDtoView> entityToDto(List<Classification> classificationsList) {

        return classificationsList.stream().map(
            obj -> entityToDto(obj)
        ).collect(Collectors.toList());
    }

    public static Classification dtoToEntity(ClassificationDtoView classificationDto) {

        Classification classification = modelMapper.map(classificationDto, Classification.class);

        return classification;
    }

    public static List<Classification> dtoToEntity(List<ClassificationDtoView> classificationsDtoList) {
        return classificationsDtoList.stream().map(
                obj -> dtoToEntity(obj)
        ).collect(Collectors.toList());
    }
}