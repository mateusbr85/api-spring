package com.avendrytech.coursespring.core.ports.output.repositories;

import com.avendrytech.coursespring.core.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

}
