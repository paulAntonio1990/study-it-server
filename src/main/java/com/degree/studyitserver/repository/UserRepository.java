package com.degree.studyitserver.repository;

import com.degree.studyitserver.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByUserName(String userName);

    Optional<User> findByUserName(String userName);

    Boolean existsByEmail(String email);
}
