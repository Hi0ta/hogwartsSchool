package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyService {

   private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id){
        return facultyRepository.findById(id).get();
    }

    public List<Faculty> findFacultyByColour(String colour){
 // нужно ли написать условие "если такого цвета нет то выдавать сообщение об этом"??
        return facultyRepository.findAll().stream().filter(e -> e.getColour().equals(colour)).collect(Collectors.toList());
    }

    public Faculty editFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id){
       facultyRepository.deleteById(id);
    }

    public Collection<Faculty> findFacultyByNameOrColour(String name, String colour){
        return facultyRepository.findFacultyByNameIgnoreCaseOrColourIgnoreCase(name, colour);
    }

    public Collection<Student> findById(long facultyId) {
        return facultyRepository.findById(facultyId);
    }
}
