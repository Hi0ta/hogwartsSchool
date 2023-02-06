package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("student/")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}") // GET http://localhost:8080/student/7
    public ResponseEntity<Student> getStudentInfo(@PathVariable long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping("age/{age}") // GET http://localhost:8080/student/age/15
    public ResponseEntity<Collection<Student>> findStudentByAge(@PathVariable int age) {
        return ResponseEntity.ok(studentService.findStudentsByAge(age));
    }

    @GetMapping("age/between") //  GET http://localhost:8080/student/age/between
    public ResponseEntity<Collection<Student>> findByAgeBetween(@RequestParam int ageMin,
                                                                @RequestParam int ageMax) {
        return ResponseEntity.ok(studentService.findByAgeBetween(ageMin, ageMax));
    }

    @PostMapping() // POST http://localhost:8080/student/
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping() // PUT http://localhost:8080/student/
    public ResponseEntity<Student> editeStudent(@RequestBody Student student) {
        Student foundStudent = studentService.editStudent(student);
        if (foundStudent == null) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("{id}") // DELETE http://localhost:8080/student/2
    public ResponseEntity deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("faculty/{facultyId}") // GET http://localhost:8080/student/faculty/1
    public ResponseEntity<Collection<Student>> findStudentsByFacultyId(@PathVariable Long facultyId) {
        return ResponseEntity.ok(studentService.findStudentsByFacultyId(facultyId));
    }

    @GetMapping("name/{name}") // GET http://localhost:8080/student/name/Harry
    public ResponseEntity<List<Student>> getStudentsByName(@PathVariable("name") String name){
        List<Student> students = studentService.getStudentsByName(name);
        return ResponseEntity.ok(students);
    }

    @GetMapping("number-all-students")
    public Integer getNumberAllStudents() {
        return studentService.getNumberAllStudents();
    }

    @GetMapping("middle-age-students")
    public Integer getMiddleAgeStudents() {
        return studentService.getMiddleAgeStudents();
    }

    @GetMapping("last5students")
    public Collection<Student> getLastFiveStudents() {
        return studentService.getLastFiveStudents();
    }
}
