package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {

    Logger logger = LoggerFactory.getLogger(FacultyService.class);
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        logger.debug("launching the createFaculty method");
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        logger.debug("launching the getFacultyInfo method with id: {}", id);
        return facultyRepository.findById(id).get();
    }

    public Collection<Faculty> findFacultyByColour(String colour) {
        logger.debug("launching the findFacultyByColour method");
        return facultyRepository.findFacultyByColourIgnoreCase(colour);
    }

    public Faculty editFaculty(Faculty faculty) {
        logger.debug("launching the editeFaculty method");
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        logger.debug("launching the deleteStudent method with id: {}", id);
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> findFacultyByNameOrColour(String name, String colour) {
        logger.debug("launching the findFaculty method");
        return facultyRepository.findFacultyByNameIgnoreCaseOrColourIgnoreCase(name, colour);
    }

    public Faculty findFacultyByStudentId(Long studentId) {
        logger.debug("launching the findFacultyByStudentId method with studentId: {}", studentId);
        return facultyRepository.findFacultyByStudentsId(studentId);
    }
}
