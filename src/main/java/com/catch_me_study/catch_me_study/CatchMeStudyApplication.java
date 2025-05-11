package com.catch_me_study.catch_me_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CatchMeStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatchMeStudyApplication.class, args);
    }

}
