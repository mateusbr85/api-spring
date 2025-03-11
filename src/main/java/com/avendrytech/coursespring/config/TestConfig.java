package com.avendrytech.coursespring.config;

import com.avendrytech.coursespring.adapters.output.database.UserRepository;
import com.avendrytech.coursespring.core.domain.entities.UserEntity;
import com.avendrytech.coursespring.core.ports.output.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        UserEntity userOne = new UserEntity(null, "Maria teste", "maria@gmail.com", "1s41281a1s");
        UserEntity userTwo = new UserEntity(null, "Marcos teste", "marcos@gmail.com", "sadsd4a4");

        userRepository.saveAll(Arrays.asList(userOne,userTwo));
    }
}
