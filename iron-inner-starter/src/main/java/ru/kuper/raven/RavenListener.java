package ru.kuper.raven;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author Ilya V. Kupriyanov
 * @version 07.03.2022
 */
public class RavenListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Отправляем ворона...");
    }
}
