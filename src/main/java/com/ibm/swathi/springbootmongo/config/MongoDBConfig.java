package com.ibm.swathi.springbootmongo.config;

import com.ibm.swathi.springbootmongo.document.Users;
import com.ibm.swathi.springbootmongo.repository.UsersRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = UsersRepository.class)
@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(UsersRepository usersRepository) {
        return strings -> {
            usersRepository.save(new Users(1, "Swathi", "Development", 2000L));
            usersRepository.save(new Users(2, "Ahalya", "IT", 1000L));
            usersRepository.save(new Users(3, "Nayana", "IT", 5000L));
            usersRepository.save(new Users(4, "Anusha", "IT", 8000L));
            usersRepository.save(new Users(5, "Akshaya", "IT", 9000L));
            usersRepository.save(new Users(6, "Monica", "IT", 12000L));
        };
    }
}
