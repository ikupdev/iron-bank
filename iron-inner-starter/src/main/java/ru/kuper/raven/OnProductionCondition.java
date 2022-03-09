package ru.kuper.raven;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Ilya V. Kupriyanov
 * @version 08.03.2022
 */
public class OnProductionCondition implements Condition {
    @SneakyThrows
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println("Это продакшен? 1 - да, 0 - нет");
        String line = bufferedReader.readLine();
        int isProduction = Integer.parseInt(line);
        return isProduction == 1;
    }
}
