package com.fahrecker.springboottutbootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.fahrecker.springboottutbootstrap.persistence.repo")
@EntityScan("com.fahrecker.springboottutboostrap.persistence.model")
@SpringBootApplication
public class SpringBootTutBootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTutBootstrapApplication.class, args);
    }

}
