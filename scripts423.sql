SELECT student.name, student.age, faculty.faculty
FROM student
         INNER JOIN faculty ON student.faculty_id = faculty.id

SELECT student.student
FROM avatars
         RIGHT JOIN student ON student.student_id = student.id