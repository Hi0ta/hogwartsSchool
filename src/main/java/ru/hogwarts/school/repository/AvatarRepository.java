package ru.hogwarts.school.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Avatar;

import java.util.Collection;
import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

    Optional<Avatar> findAvatarByStudentId(Long studentId);

    @Query(value = "SELECT * FROM avatar ORDER BY id", nativeQuery = true)
    Collection<Avatar> getAllAvatars(PageRequest pageRequest);
}
