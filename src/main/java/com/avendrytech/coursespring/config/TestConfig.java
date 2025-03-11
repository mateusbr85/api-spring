package com.avendrytech.coursespring.config;

import com.avendrytech.coursespring.core.domain.entities.CategoryEntity;
import com.avendrytech.coursespring.core.domain.entities.OrderEntity;
import com.avendrytech.coursespring.core.domain.entities.UserEntity;
import com.avendrytech.coursespring.core.domain.enums.OrderStatusEnum;
import com.avendrytech.coursespring.core.ports.output.repositories.ICategoryRepository;
import com.avendrytech.coursespring.core.ports.output.repositories.IOrderRepository;
import com.avendrytech.coursespring.core.ports.output.repositories.IUserRepository;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        UserEntity userOne = new UserEntity(null, "Maria teste", "maria@gmail.com", "1s41281a1s");
        UserEntity userTwo = new UserEntity(null, "Marcos teste", "marcos@gmail.com", "sadsd4a4");

        userRepository.saveAll(Arrays.asList(userOne,userTwo));

        OrderEntity o1 = new OrderEntity(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatusEnum.PAID, userOne);
        OrderEntity o2 = new OrderEntity(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatusEnum.CANCELED, userTwo);
        OrderEntity o3 = new OrderEntity(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatusEnum.DELIVERED,userOne);

        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

        CategoryEntity cat1 = new CategoryEntity(null, "Electronics");
        CategoryEntity cat2 = new CategoryEntity(null, "Books");
        CategoryEntity cat3 = new CategoryEntity(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
    }
}
