package com.salemnabeel.wikicoursesapp.mapper;

import com.salemnabeel.wikicoursesapp.dto.ClassificationDto;
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

        // ClassificationDTO classificationDTO = modelMapper.map(classification, classificationDTO.class);

        ClassificationDto classificationDTO = new ClassificationDto();

        // For Classification Id
        classificationDTO.setId(classification.getId());

        // For Classification Title
        classificationDTO.setTitle(classification.getTitle());

        Section section = classification.getSection();

        // For Section Title
        classificationDTO.setSectionTitle(section.getTitle());

        return classificationDTO;
    }

    public List<ClassificationDto> entityToDto(List<Classification> classificationsList) {

        return classificationsList.stream().map(
            classification -> entityToDto(classification)
        ).collect(Collectors.toList());
    }

    public Classification dtoToEntity(ClassificationDto classificationDto) {

        // Classification classification = new Classification();

        // classification.setId(classificationDTO.getId());

        // classification.setTitle(classificationDTO.getTitle());

        // classification.setIsActive(classificationDTO.getIsActive());

        ModelMapper modelMapper = new ModelMapper();

        Classification classification = modelMapper.map(classificationDto, Classification.class);

        return classification;
    }

    public List<Classification> dtoToEntity(List<ClassificationDto> classificationsDtoList) {
        return classificationsDtoList.stream().map(
                classificationDto -> dtoToEntity(classificationDto)).collect(Collectors.toList()
        );
    }
}