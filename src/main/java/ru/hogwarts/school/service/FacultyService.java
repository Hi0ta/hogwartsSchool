package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }  //   V

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).get();
    }  //   V

    public Collection<Faculty> findFacultyByColour(String colour) {
        return facultyRepository.findFacultyByColourIgnoreCase(colour);
    }

    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }  //   V

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }  //   V

    public Collection<Faculty> findFacultyByNameOrColour(String name, String colour) {
        return facultyRepository.findFacultyByNameIgnoreCaseOrColourIgnoreCase(name, colour);
    }  //  V

    public Faculty findFacultyByStudentId(Long studentId) {
        return facultyRepository.findFacultyByStudentsId(studentId);
    }
}
