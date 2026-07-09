package com.ems.ems.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.ems.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByStudentId(String studentId);

}
