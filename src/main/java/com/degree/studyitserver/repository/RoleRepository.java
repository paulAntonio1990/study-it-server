package com.degree.studyitserver.repository;

import com.degree.studyitserver.domain.entity.Role;
import com.degree.studyitserver.domain.types.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType name);
}
