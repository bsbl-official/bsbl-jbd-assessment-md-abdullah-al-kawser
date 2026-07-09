package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Course;
import entity.Enrollment;
import entity.Student;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long>{

    boolean existsByStudentAndCourseAndSemester(
            Student student,
            Course course,
            String semester);

    long countByStudentAndSemester(Student student,String semester);

    List<Enrollment> findByStudent(Student student);

}