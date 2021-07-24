package com.example.jpaadvanceddemo.repository;

import com.example.jpaadvanceddemo.dao.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

    @Query("SELECT sectionId, AVG(score) from Grade GROUP BY sectionId ORDER BY AVG(score) ASC")
    Object[][] findAverageScoreBySection();

    //Find all students with an average score lower than value passed as arg
    @Query("Select studentName, AVG(score) FROM Grade GROUP BY studentName HAVING AVG(score) < :score")
    List<Object[]> findAverageScoreLowerThan(@Param("score") double score);

    //Find all the students with an average score having at least a minimum quantity
    @Query("SELECT sectionId, AVG(score), COUNT(*) FROM Grade GROUP BY sectionId HAVING COUNT(*) >= :minEnrolled ORDER BY AVG(score)" )
    List<Object[]> findAverageScoreBySectionWithCapacity(@Param("minEnrolled") long minEnrolled);

    @Query("SELECT sectionId, MAX(score) FROM Grade GROUP BY sectionId")
    List<Object[]> findMaxScoreBySection();

    @Query(value = "SELECT student_name, CAST(AVG(score) as double) FROM grade GROUP BY student_name HAVING AVG(score) < :score", nativeQuery = true)
    List<Object[]> findAverageScoreByStudentNameNativeQueryTest(@Param("score") double score);
}
