package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findFacultyByNameIgnoreCaseOrColourIgnoreCase(String name, String colour);

    Faculty findFacultyByStudentsId(Long id);

    Collection<Faculty> findFacultyByColourIgnoreCase(String colour);

    List<Faculty> findAll();
}
