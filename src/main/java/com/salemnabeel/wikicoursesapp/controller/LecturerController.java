package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.dto.lecturer.LecturerDtoView;
import com.salemnabeel.wikicoursesapp.dto.lecturer.LecturerLoginDto;
import com.salemnabeel.wikicoursesapp.dto.lecturer.LecturerStatisticsDto;
import com.salemnabeel.wikicoursesapp.model.Lecturer;
import com.salemnabeel.wikicoursesapp.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

    @GetMapping("/all-lecturers")
    public List<LecturerDtoView> getAllLecturers() {

        return lecturerService.getAllLecturers();
    }

    @GetMapping("/active-lecturers")
    public List<LecturerDtoView> getAllActiveLecturers() {

        return lecturerService.getAllActiveLecturers();
    }

    @PostMapping("/add-lecturer")
    public LecturerDtoView createNewLecturer(@Valid @RequestBody Lecturer lecturerRequest) {

        return lecturerService.createNewLecturer(lecturerRequest);
    }

    @PutMapping("/edit-lecturer/{lecturer-id}")
    public LecturerDtoView updateLecturerInfoById(@PathVariable("lecturer-id") Long lecturerId,
                                                  @Valid @RequestBody Lecturer lecturerRequest) {

        return lecturerService.updateLecturerInfoById(lecturerId, lecturerRequest);
    }

    @DeleteMapping("/delete-lecturer/{lecturer-id}")
    public ResponseEntity deleteLecturerById(@PathVariable("lecturer-id") Long lecturerId) {

        return lecturerService.deleteLecturerById(lecturerId);
    }

    @GetMapping("/lecturer-statics")
    public LecturerStatisticsDto getLecturerStatics() {

        return lecturerService.getLecturerStatics();
    }

    @PostMapping("/lecturer-login")
    public LecturerDtoView handleLecturerLogin(@RequestBody LecturerLoginDto lecturerLoginDtoRequest) {

        return lecturerService.handleLecturerLogin(lecturerLoginDtoRequest);
    }
}