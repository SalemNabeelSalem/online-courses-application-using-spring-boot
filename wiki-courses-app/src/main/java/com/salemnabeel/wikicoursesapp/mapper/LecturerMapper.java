package com.salemnabeel.wikicoursesapp.mapper;

import com.salemnabeel.wikicoursesapp.dto.LecturerDto;
import com.salemnabeel.wikicoursesapp.model.Lecturer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LecturerMapper {

    public LecturerDto entityToDto(Lecturer lecturer) {

        ModelMapper modelMapper = new ModelMapper();

        LecturerDto lecturerDto = modelMapper.map(lecturer, LecturerDto.class);

        return lecturerDto;
    }

    public List<LecturerDto> entityToDto(List<Lecturer> lecturersList) {

        return lecturersList.stream().map(lecturer -> entityToDto(lecturer)).collect(Collectors.toList());
    }

    public Lecturer dtoToEntity(LecturerDto lecturerDto) {

        ModelMapper modelMapper = new ModelMapper();

        Lecturer lecturer = modelMapper.map(lecturerDto, Lecturer.class);

        return lecturer;
    }

    public List<Lecturer> dtoToEntity(List<LecturerDto> lecturersDtoList) {

        return lecturersDtoList.stream().map(lecturerDto -> dtoToEntity(lecturerDto)).collect(Collectors.toList());
    }
}