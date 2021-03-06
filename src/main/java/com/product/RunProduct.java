package com.product;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.product.productdao"})
@EntityScan(basePackages ={"com.product.productmodel"})
public class RunProduct {

    public static void main(String[] args) {

        SpringApplication.run(RunProduct.class, args);

    }
}
