package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.dto.LecturerDto;
import com.salemnabeel.wikicoursesapp.model.Lecturer;
import com.salemnabeel.wikicoursesapp.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

    @GetMapping("/lecturers")
    public List<LecturerDto> getAllActiveLecturers() {

        return lecturerService.getAllActiveLecturers();
    }

    @GetMapping("/lecturers/{lecturer-id}")
    public List<LecturerDto> getActiveLecturerById(@PathVariable("lecturer-id") Long lecturerId) {

        return lecturerService.getActiveLecturerById(lecturerId);
    }

    @PostMapping("/lecturers")
    public LecturerDto createNewLecturer(@Valid @RequestBody Lecturer lecturerRequest) {

        return lecturerService.createNewLecturer(lecturerRequest);
    }

    @PutMapping("/lecturers/{lecturer-id}")
    public LecturerDto updateLecturerInfoById(@PathVariable("lecturer-id") Long lecturerId,
                                              @Valid @RequestBody Lecturer lecturerRequest) {

        return lecturerService.updateLecturerInfoById(lecturerId, lecturerRequest);
    }

    @DeleteMapping("/lecturers/{lecturer-id}")
    public ResponseEntity deActivateLecturerById(@PathVariable("lecturer-id") Long lecturerId) {

        return lecturerService.deActivateLecturerById(lecturerId);
    }
}