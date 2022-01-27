package org.iesfm.high.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ApiMain {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ApiMain.class, args);

    }
}
