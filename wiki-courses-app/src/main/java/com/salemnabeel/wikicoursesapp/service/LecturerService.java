package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.mapper.LecturerMapper;
import com.salemnabeel.wikicoursesapp.dto.view.LecturerDto;
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

    @Autowired
    private LecturerMapper lecturerMapper;

    public List<LecturerDto> getAllActiveLecturers() {

        List<Lecturer> lecturersList = lecturerRepository.getAllActiveLecturers();

        return lecturerMapper.entityToDto(lecturersList);
    }

    public LecturerDto createNewLecturer(Lecturer lecturerRequest) {

        lecturerRequest.setIsActive(true);

        return lecturerMapper.entityToDto(
            lecturerRepository.save(lecturerRequest)
        );
    }

    public List<LecturerDto> getActiveLecturerById(Long lecturerId) {

        List<Lecturer> lecturersList = lecturerRepository.getActiveLecturerById(lecturerId);

        return lecturerMapper.entityToDto(lecturersList);
    }

    public LecturerDto updateLecturerInfoById(Long lecturerId, Lecturer lecturerRequest) {

        if (lecturerRepository.getActiveLecturerById(lecturerId).isEmpty()) {

            throw new ResourceNotFoundException("resource not found.");
        }

        Lecturer lecturer = lecturerRepository.getActiveLecturerById(lecturerId).get(0);

        lecturer.setFullName(lecturerRequest.getFullName());

        lecturer.setEmail(lecturerRequest.getEmail());

        lecturer.setProfileImageLink(lecturerRequest.getProfileImageLink());

        return lecturerMapper.entityToDto(
            lecturerRepository.save(lecturer)
        );
    }

    public ResponseEntity deActivateLecturerById(Long lecturerId) {

        if (lecturerRepository.getActiveLecturerById(lecturerId).isEmpty()) {

            throw new ResourceNotFoundException("resource not found.");
        }

        Lecturer lecturer = lecturerRepository.getActiveLecturerById(lecturerId).get(0);

        lecturer.setIsActive(false);

        lecturerRepository.save(lecturer);

        return ResponseEntity.ok().build();
    }
}