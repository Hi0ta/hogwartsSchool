package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).get();
    }

    public Collection<Student> findStudentsByAge(int age) {
        return studentRepository.findStudentsByAge(age);
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAgeBetween(int ageMin, int ageMax) {
        return studentRepository.findStudentsByAgeBetween(ageMin, ageMax);
    }

    public Collection<Student> findStudentsByFacultyId(Long facultyId) {
        return studentRepository.findStudentsByFacultyId(facultyId);
    }
}
