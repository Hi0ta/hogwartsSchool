package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Student> getStudentsByName(String name) {
        logger.debug("launching the getStudentsByName method   with name: {}", name);
        return studentRepository.getStudentsByName(name);
    }

    public List<String> getNameBeginsWithA() {
        return studentRepository.findAll().stream()
                .map(Student::getName)
                .filter(e -> e.startsWith("A"))
                .sorted().map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public Double getMiddleAgeAllStudents() {
        return studentRepository.findAll()
                .parallelStream()
                .collect(Collectors.averagingInt(Student::getAge));
    }

    public void printSixName(){
        //  List<String> names = studentRepository.findAll().stream().map(Student::getName).toList();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " № 3 " + getListName(2));
            System.out.println(Thread.currentThread().getName() + " № 4 " + getListName(3));
        }).start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " № 5 " + getListName(4));
            System.out.println(Thread.currentThread().getName() + " № 6 " + getListName(5));
        }).start();
        System.out.println(Thread.currentThread().getName() + " № 1 " + getListName(0));
        System.out.println(Thread.currentThread().getName() + " № 2 " + getListName(1));
    }

    public String getListName(int num){
        List<String> names = studentRepository.findAll()
                .stream().map(Student::getName).toList();
        return names.get(num);
    }

    public synchronized void printStudentName(int num){
        System.out.println(getListName(num));
    }

    public void printSixNameSync(){
            new Thread(() -> {
                printStudentName(2);
                printStudentName(3);
            }).start();
            new Thread(() -> {
                printStudentName(4);
                printStudentName(5);
            }).start();
        printStudentName(0);
        printStudentName(1);
    }

//    public int count = 1;
//    public synchronized int getCount(){
//        return count++;
//    }
}
