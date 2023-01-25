package ru.hogwarts.school.service;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {return studentRepository.save(student);}

    public Student findStudent(long id) {return studentRepository.findById(id).get();}

    public List<Student> findStudentByAge(long age) {
        return studentRepository.findAll().stream().filter(e -> e.getAge() == age).collect(Collectors.toList());
    }

    public Student editStudent(Student student) {return studentRepository.save(student);}

    public void deleteStudent(long id) {studentRepository.deleteById(id);}

    public Collection<Student> findByAgeBetween(int ageMin, int ageMax) {
        return studentRepository.findStudentsByAgeBetween(ageMin, ageMax);
    }

    public Collection<Student> findStudentsByFacultyId(Long facultyId){
        return studentRepository.findStudentsByFacultyId(facultyId);
    };

}
