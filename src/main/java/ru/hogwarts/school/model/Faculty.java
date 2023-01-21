package ru.hogwarts.school.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Faculty {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String colour;
    @OneToMany(mappedBy = "faculty")
    private Collection<Student> students;

    public Faculty(Long id, String name, String colour) {
        this.id = id;
        this.name = name;
        this.colour = colour;
    }

    public Faculty() {}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getColour() {return colour;}

    public void setColour(String colour) {this.colour = colour;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(id, faculty.id) && name.equals(faculty.name) && colour.equals(faculty.colour);
    }

    @Override
    public int hashCode() {return Objects.hash(id, name, colour);}

    @Override
    public String toString() {return "Faculty " + name + ", colour: " + colour;}
}
