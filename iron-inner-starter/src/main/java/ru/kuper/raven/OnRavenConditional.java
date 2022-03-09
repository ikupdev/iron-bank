package ru.kuper.raven;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

/**
 * @author Ilya V. Kupriyanov
 * @version 09.03.2022
 */
public class OnRavenConditional extends AllNestedConditions {

    public OnRavenConditional() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    @ConditionalOnProperty("raven.where")
    public static class R{}

    @ConditionalOnProperty(value = "raven.onoff", havingValue = "true")
    public static class C{}

}
