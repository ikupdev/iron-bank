package ru.kuper.raven;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Ilya V. Kupriyanov
 * @version 08.03.2022
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Conditional({OnProductionCondition.class})
public @interface ConditionOnProduction {

}
