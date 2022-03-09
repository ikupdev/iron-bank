package ru.kuper.raven;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Ilya V. Kupriyanov
 * @version 09.03.2022
 */
@Retention(RetentionPolicy.RUNTIME)
@Conditional({OnRavenConditional.class})
public @interface ConditionalOnRaven {

}
