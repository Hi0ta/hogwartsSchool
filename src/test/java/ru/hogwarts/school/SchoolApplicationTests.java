package ru.hogwarts.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Profile;
import ru.hogwarts.school.controller.StudentController;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SchoolApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private StudentController studentController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception {
        Assertions.assertThat(studentController).isNotNull();
    }

    @Test
    public void testGetStudentInfo() throws Exception {
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/7", String.class)).isNotNull();
    }

    @Test
    public void testFindStudentByAge() throws Exception {
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/age/15", String.class)).isNotNull();
    }

    @Test
    public void testFindByAgeBetween() throws Exception {
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/age/between", String.class)).isNotNull();
    }

//    @Test
//    public void testPostCreateStudent() throws Exception {
//        Student student = new Student();
//        //student.setId(5L);
//        student.setName("Student");
//        student.setAge(9);
//
//        Assertions.assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/student/", student, String.class)).isNotNull();
//        Assertions.assertThat(this.restTemplate.delete("http://localhost:" + port + "/student/" + student.getId(), student, String.class)).isNotNull();
//    }  //что то пошло не так...

    @Test
    public void testFindStudentsByFacultyId() throws Exception {
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/faculty/1", String.class)).isNotNull();
    }
}
