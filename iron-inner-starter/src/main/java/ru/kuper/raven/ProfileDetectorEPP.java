package ru.kuper.raven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author Ilya V. Kupriyanov
 * @version 09.03.2022
 * //Выполняется перед инициализацией бинов (до ApplicationContextInitializer-ов), после настройки окружения
 */
public class ProfileDetectorEPP implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        if (environment.getActiveProfiles().length == 0) {
            String profile = (getTemperature() < 272) ? "WinterThere" : "WinterIsComing";
            environment.setActiveProfiles(profile);
        } else {
            System.out.println("We do not need to set Profile!");
        }
    }

    private int getTemperature() {
        return -300;
    }
}
