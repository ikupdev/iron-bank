package ru.kuper.raven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author Ilya V. Kupriyanov
 * @version 09.03.2022
 */
public class ProfileDetectorEPP implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        if (environment.getActiveProfiles().length == 0 && getTemperature() < 272) {
            environment.setActiveProfiles("WinterThere");
        } else {
            environment.setActiveProfiles("WinterIsComing");
        }

    }

    private int getTemperature() {
        return -300;
    }
}
