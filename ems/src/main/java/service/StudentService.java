package service;

import java.util.List;

import entity.Student;

public interface StudentService {

    Student createStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);

}
