package com.avendrytech.coursespring.config;

import com.avendrytech.coursespring.core.domain.entities.CategoryEntity;
import com.avendrytech.coursespring.core.domain.entities.OrderEntity;
import com.avendrytech.coursespring.core.domain.entities.ProductEntity;
import com.avendrytech.coursespring.core.domain.entities.UserEntity;
import com.avendrytech.coursespring.core.domain.enums.OrderStatusEnum;
import com.avendrytech.coursespring.core.ports.output.repositories.ICategoryRepository;
import com.avendrytech.coursespring.core.ports.output.repositories.IOrderRepository;
import com.avendrytech.coursespring.core.ports.output.repositories.IProductRepository;
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

    @Autowired
    private IProductRepository productRepository;

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

        ProductEntity p1 = new ProductEntity(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        ProductEntity p2 = new ProductEntity(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        ProductEntity p3 = new ProductEntity(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        ProductEntity p4 = new ProductEntity(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        ProductEntity p5 = new ProductEntity(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
    }
}
