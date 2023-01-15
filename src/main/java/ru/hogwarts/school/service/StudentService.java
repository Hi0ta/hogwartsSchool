package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final Map<Long, Student> students = new HashMap<>();
    private long lastId = 0;

    public Student createStudent(Student student){
        student.setId(++lastId);
        students.put(student.getId(), student);
        return student;
    }

    public Student findStudent(long id){
        if (!students.containsKey(id)){
            return null;
        }
        return students.get(id);
    }

    public List<Student> findStudentByAge(long age){
        //   if (!faculties.containsValue(color))  //написать условие "если такого возраста нет то выдавать сообщение об этом"
        return students.values().stream().filter(e -> e.getAge() == age).collect(Collectors.toList());
    }

    public Student editStudent(Student student){
        if (!students.containsKey(student.getId())) {
            return null;
        }
        students.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(long id){
        return students.remove(id);
    }


}
