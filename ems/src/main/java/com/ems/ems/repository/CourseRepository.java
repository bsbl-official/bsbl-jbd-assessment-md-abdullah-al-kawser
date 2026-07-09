package com.ems.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.ems.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Long>{

    boolean existsByCourseCode(String courseCode);

}
