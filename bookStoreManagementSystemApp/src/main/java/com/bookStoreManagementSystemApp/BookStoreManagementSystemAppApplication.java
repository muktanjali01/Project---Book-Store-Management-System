package com.bookStoreManagementSystemApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.bookStoreManagementSystemApp.repository")
public class BookStoreManagementSystemAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreManagementSystemAppApplication.class, args);
    }
}
