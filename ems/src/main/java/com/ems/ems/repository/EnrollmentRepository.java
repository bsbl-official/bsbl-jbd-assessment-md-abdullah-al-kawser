package com.ems.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.ems.entity.Course;
import com.ems.ems.entity.Enrollment;
import com.ems.ems.entity.Student;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long>{

    boolean existsByStudentAndCourseAndSemester(
            Student student,
            Course course,
            String semester);

    long countByStudentAndSemester(Student student,String semester);

    List<Enrollment> findByStudent(Student student);

}