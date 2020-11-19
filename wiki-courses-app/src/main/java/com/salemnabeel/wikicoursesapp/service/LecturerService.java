package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.mapper.LecturerMapper;
import com.salemnabeel.wikicoursesapp.dto.lecturer.LecturerDtoView;
import com.salemnabeel.wikicoursesapp.exception.ResourceNotFoundException;
import com.salemnabeel.wikicoursesapp.model.Lecturer;
import com.salemnabeel.wikicoursesapp.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerService {

    @Autowired
    private LecturerRepository lecturerRepository;

    public List<LecturerDtoView> getAllLecturers() {

        List<Lecturer> lecturersList = lecturerRepository.findAll();

        lecturersList.sort((s1, s2) -> s2.getId().compareTo(s1.getId()));

        return LecturerMapper.entityToDto(lecturersList);
    }

    public List<LecturerDtoView> getAllActiveLecturers() {

        List<Lecturer> lecturersList = lecturerRepository.getAllActiveLecturers();

        lecturersList.sort((s1, s2) -> s2.getId().compareTo(s1.getId()));

        return LecturerMapper.entityToDto(lecturersList);
    }

    public LecturerDtoView createNewLecturer(Lecturer lecturerRequest) {

        lecturerRequest.setIsActive(true);

        return LecturerMapper.entityToDto(
            lecturerRepository.save(lecturerRequest)
        );
    }

    public LecturerDtoView updateLecturerInfoById(Long lecturerId, Lecturer lecturerRequest) {

        if (lecturerRepository.findById(lecturerId).isEmpty()) {

            throw new ResourceNotFoundException("lecturer resource not found.");
        }

        Lecturer lecturer = lecturerRepository.findById(lecturerId).get();

        lecturer.setFullName(lecturerRequest.getFullName());

        lecturer.setEmail(lecturerRequest.getEmail());

        lecturer.setProfileImageLink(lecturerRequest.getProfileImageLink());

        lecturer.setIsActive(lecturerRequest.getIsActive());

        return LecturerMapper.entityToDto(lecturerRepository.save(lecturer));
    }

    public ResponseEntity deleteLecturerById(Long lecturerId) {

        if (lecturerRepository.findById(lecturerId).isEmpty()) {

            throw new ResourceNotFoundException("lecturer resource not found.");
        }

        Lecturer lecturer = lecturerRepository.findById(lecturerId).get();

        lecturerRepository.delete(lecturer);

        return ResponseEntity.ok().build();
    }
}