package ru.kuper.ironbank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.kuper.ironbank.ProfileConstants;
import ru.kuper.ironbank.model.ProphetProperties;

/**
 * @author Ilya V. Kupriyanov
 * @version 09.03.2022
 */
@Service
@Profile(ProfileConstants.WINTER_IS_COMING)
@RequiredArgsConstructor
public class WhiteListBackendProphetService implements ProphetService {
    private final ProphetProperties prophetProperties;

    @Override
    public boolean willSurvive(String name) {
        return prophetProperties.getReturning().contains(name);
    }
}
