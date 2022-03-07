package ru.kuper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ilya V. Kupriyanov
 * @version 07.03.2022
 */
@Configuration
public class IronConfig {

    @Bean
    public RavenListener ravenListener() {
        return new RavenListener();
    }

}
