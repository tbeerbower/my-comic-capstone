package com.techelevator.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    EventHandler repositoryEventHandler() {
        return new EventHandler();
    }
}
