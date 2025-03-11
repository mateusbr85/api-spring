package com.avendrytech.coursespring.core.domain.useCases;

import com.avendrytech.coursespring.core.domain.entities.UserEntity;
import com.avendrytech.coursespring.core.ports.output.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserUseCase {

    @Autowired
    private IUserRepository userRepository;

    public List<UserEntity> findALl() {
        return userRepository.findAll();
    }

    public UserEntity findById(Long id) {
        Optional<UserEntity> obj = userRepository.findById(id);
        return obj.get();
    }
}
