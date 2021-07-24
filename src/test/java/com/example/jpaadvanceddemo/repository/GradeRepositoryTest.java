package com.example.jpaadvanceddemo.repository;

import com.example.jpaadvanceddemo.dao.Grade;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GradeRepositoryTest {

    @Autowired
    private GradeRepository gradeRepository;

    private List<Grade> grades;

    @BeforeEach
    void setUp() {
        grades = gradeRepository.saveAll(List.of(
                new Grade("Maya Charlotte", "CS101-A", 98),
                new Grade("James Fields", "CS101-A", 82),
                new Grade("Michael Alcocer", "CS101-B", 65),
                new Grade("Maya Charlotte", "CS103-A", 89),
                new Grade("Tomas Lacroix", "CS101-A", 99),
                new Grade("Sara Bisat", "CS101-A", 87),
                new Grade("James Fields", "CS101-B", 46),
                new Grade("Helena Sepulvida", "CS103-A", 72)
        ));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAverageScoreBySection_ValidateSectionAndAverage() {
        Object[][] results = gradeRepository.findAverageScoreBySection();
        assertEquals(3, results.length);
        assertEquals(55.5, results[0][1]);
    }

    @Test
    void findAverageScoreLowerThanParamValue(){
        List<Object[]> avgScore = gradeRepository.findAverageScoreLowerThan(70);
        assertEquals(2, avgScore.size());
        assertEquals("James Fields", avgScore.get(0)[0]);
    }

    @Test
    void findAverageSocreBySectionWithCapacityTest(){
        List<Object[]> capacity = gradeRepository.findAverageScoreBySectionWithCapacity(3);
        assertEquals(1, capacity.size());
    }

    @Test
    void findMaxScoreBySection() {
        List<Object[]> maxScoreBySection = gradeRepository.findMaxScoreBySection();
        assertEquals(3, maxScoreBySection.size());
        assertEquals("CS101-A",maxScoreBySection.get(0)[0]);
        assertEquals(65,maxScoreBySection.get(1)[1]);
        assertEquals(89,maxScoreBySection.get(2)[1]);
    }

    @Test
    void findAverageScoreByStudentNameNativeQueryTest(){
        List<Object[]> studentScores = gradeRepository.findAverageScoreByStudentNameNativeQueryTest(80);
        assertEquals(3, studentScores.size());
    }
}