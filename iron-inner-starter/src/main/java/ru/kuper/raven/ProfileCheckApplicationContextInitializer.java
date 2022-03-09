package ru.kuper.raven;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author Ilya V. Kupriyanov
 * @version 09.03.2022
 */
public class ProfileCheckApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        if (environment.getActiveProfiles().length == 0) {
            throw new RuntimeException("Без профиля нельзя!");
        }
    }
}
