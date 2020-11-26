package com.salemnabeel.wikicoursesapp.mapper;

import com.salemnabeel.wikicoursesapp.dto.lecturer.LecturerDtoView;
import com.salemnabeel.wikicoursesapp.model.Lecturer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LecturerMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static LecturerDtoView entityToDto(Lecturer lecturer) {

        LecturerDtoView lecturerDtoView = modelMapper.map(lecturer, LecturerDtoView.class);

        return lecturerDtoView;
    }

    public static List<LecturerDtoView> entityToDto(List<Lecturer> lecturersList) {

        return lecturersList.stream().map(
            obj -> entityToDto(obj)
        ).collect(Collectors.toList());
    }

    public static Lecturer dtoToEntity(LecturerDtoView lecturerDtoView) {

        Lecturer lecturer = modelMapper.map(lecturerDtoView, Lecturer.class);

        return lecturer;
    }

    public static List<Lecturer> dtoToEntity(List<LecturerDtoView> lecturersDtoList) {

        return lecturersDtoList.stream().map(
            obj -> dtoToEntity(obj)
        ).collect(Collectors.toList());
    }
}