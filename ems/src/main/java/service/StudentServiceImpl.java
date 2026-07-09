package service;

import java.util.List;

import org.springframework.stereotype.Service;

import entity.Student;
import exception.ResourceNotFoundException;
import repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {

        if (studentRepository.existsByStudentId(student.getStudentId())) {
            throw new IllegalArgumentException("Student ID already exists.");
        }

        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {

        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id : " + id));

    }

    @Override
    public Student updateStudent(Long id, Student student) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id : " + id));

        // Check duplicate Student ID
        if (!existingStudent.getStudentId().equals(student.getStudentId())
                && studentRepository.existsByStudentId(student.getStudentId())) {

            throw new IllegalArgumentException("Student ID already exists.");
        }

        existingStudent.setStudentId(student.getStudentId());
        existingStudent.setFullName(student.getFullName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setAdmissionDate(student.getAdmissionDate());

        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id : " + id));

        studentRepository.delete(student);
    }
}
