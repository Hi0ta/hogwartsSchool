package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final Map<Long, Faculty> faculties = new HashMap<>();
    private long lastId = 0;

    public Faculty createFaculty(Faculty faculty){
        faculty.setId(++lastId);
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty findFaculty(long id){
        if (!faculties.containsKey(id)){
            return null;
        }
        return faculties.get(id);
    }

    public List<Faculty> findFacultyByColour(String colour){
     //   if (!faculties.containsValue(colour))  //написать условие "если такого цвета нет то выдавать сообщение об этом"
        return faculties.values().stream().filter(e -> e.getColour().equals(colour)).collect(Collectors.toList());
    }

    public Faculty editFaculty(Faculty faculty){
        if (!faculties.containsKey(faculty.getId())) {
            return null;
        }
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deleteFaculty(long id){
        return faculties.remove(id);
    }

}
