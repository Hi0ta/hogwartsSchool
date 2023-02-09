package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        logger.debug("launching the createStudent method");
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        logger.debug("launching the getStudentInfo method with id: {}", id);
        return studentRepository.findById(id).get();
    }

    public Collection<Student> findStudentsByAge(int age) {
        logger.debug("launching the findStudentByAge method with age: {}", age);
        return studentRepository.findStudentsByAge(age);
    }

    public Student editStudent(Student student) {
        logger.debug("launching the editeStudent method");
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        logger.debug("launching the deleteStudent method with id: {}", id);
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAgeBetween(int ageMin, int ageMax) {
        logger.debug("launching the findByAgeBetween method");
        return studentRepository.findStudentsByAgeBetween(ageMin, ageMax);
    }

    public Collection<Student> findStudentsByFacultyId(Long facultyId) {
        logger.debug("launching the findStudentsByFacultyId method with facultyId: {}", facultyId);
        return studentRepository.findStudentsByFacultyId(facultyId);
    }

    public Integer getNumberAllStudents() {
        logger.debug("launching the getNumberAllStudents method");
        return studentRepository.getNumberAllStudents();
    }

    public Integer getMiddleAgeStudents() {
        logger.debug("launching the getMiddleAgeStudents method");
        return studentRepository.getMiddleAgeStudents();
    }

    public Collection<Student> getLastFiveStudents() {
        logger.debug("launching the getLastFiveStudents method");
        return studentRepository.getLastFiveStudents();
    }

    public List<Student> getStudentsByName(String name){
        logger.debug("launching the getStudentsByName method   with name: {}", name);
        return studentRepository.getStudentsByName(name);
    }
}
