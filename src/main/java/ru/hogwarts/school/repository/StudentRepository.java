package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findStudentsByAgeBetween(int ageMin, int ageMax);

    Collection<Student> findStudentsByFacultyId(Long id);

    Collection<Student> findStudentsByAge(int age);

    @Query(value = "SELECT COUNT(*) FROM student", nativeQuery = true)
    Integer getNumberAllStudents();

    @Query(value = "SELECT AVG(age) AS avg FROM student", nativeQuery = true)
    Integer getMiddleAgeStudents();

    @Query(value = "SELECT * FROM student ORDER BY id DESC LIMIT 5", nativeQuery = true)
    Collection<Student> getLastFiveStudents();
}
