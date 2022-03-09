package ru.kuper.ironbank;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.kuper.raven.RavenListener;
import ru.kuper.raven.RavenProperties;

/**
 * @author Ilya V. Kupriyanov
 * @version 09.03.2022
 */
@Component
public class MyRavenListener extends RavenListener {
    public MyRavenListener(RavenProperties ravenProperties) {
        super(ravenProperties);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("event = " + event);
    }
}
