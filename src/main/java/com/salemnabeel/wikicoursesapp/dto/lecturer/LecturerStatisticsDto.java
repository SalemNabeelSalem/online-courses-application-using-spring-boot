package com.salemnabeel.wikicoursesapp.dto.lecturer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LecturerStatisticsDto {

    private BigInteger totalLecturers;

    private BigInteger activeLecturers;

    private BigInteger notActiveLecturers;

    private BigInteger maleLecturers;

    private BigInteger femaleLecturers;
}
