package ru.kuper.ironbank.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Ilya V. Kupriyanov
 * @version 06.03.2022
 */
@Service
public class NameBasedProphetService implements ProphetService {
    @Override
    public boolean willSurvive(String name) { //Старки всегда умирают
        return !name.contains("Stark") && ThreadLocalRandom.current().nextBoolean();
    }
}
