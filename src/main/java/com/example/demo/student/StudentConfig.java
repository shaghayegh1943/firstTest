package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.util.List;

/**
 * adding some more Static datas
 */
@Configuration
public class StudentConfig {
    @Bean
    //CommandLineRunner interface method take parameters therefore i use args inside my lambda implementation method
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return (args)-> {
            Student shirin = new Student("Shirin fake",
                    LocalDate.of(1988, 5, 27),                    "shirin@gmail.com");

            Student ben = new Student("Ben dumb",
                    LocalDate.of(1981, 5, 27),                    "Ben@gmail.com");

            repository.saveAll(List.of(shirin,ben));
        };

    }
}
