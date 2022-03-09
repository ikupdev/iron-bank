package ru.kuper.raven;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import static java.text.MessageFormat.format;

/**
 * @author Ilya V. Kupriyanov
 * @version 07.03.2022
 */
@RequiredArgsConstructor
public class RavenListener implements ApplicationListener<ContextRefreshedEvent> {
    private final RavenProperties ravenProperties;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ravenProperties.getWhere().forEach(s -> {
            System.out.println(format("Отправляем ворона... в {0}", s));
        });
    }
}
