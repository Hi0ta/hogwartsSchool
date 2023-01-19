package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("faculty/")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}") // http://localhost:8080/faculty/2
    public ResponseEntity<Faculty> getFacultyInfo(@PathVariable long id){
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @GetMapping("colour") // http://localhost:8080/faculty/colour
    public List<Faculty> findFacultyByColour(@RequestParam("colour") String colour) {
    return facultyService.findFacultyByColour(colour);
    }

    @GetMapping("student") // http://localhost:8080/faculty/student
    public Faculty findFacultyByStudents(@RequestParam Student student) {
        return facultyService.findFacultyByStudents(student);
    }

    @GetMapping("find") // http://localhost:8080/faculty/find
    public ResponseEntity findFaculty(@RequestParam (required = false) String name,
                                      @RequestParam (required = false) String colour) {
    return ResponseEntity.ok(facultyService.findFacultyByNameOrColour(name, colour));
    }

    @PostMapping() // http://localhost:8080/faculty/
    public Faculty createFaculty(@RequestBody Faculty faculty){
        return facultyService.createFaculty(faculty);
    }

    @PutMapping() // PUT http://localhost:8080/faculty/
    public ResponseEntity<Faculty> editeFaculty(@RequestBody Faculty faculty) {
        Faculty foundFaculty = facultyService.editFaculty(faculty);
        if (foundFaculty == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundFaculty);
    }

    @DeleteMapping("{id}") // DELETE http://localhost:8080/faculty/2
    public ResponseEntity deleteStudent(@PathVariable long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

}
