package ru.kuper.ironbank.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.kuper.ironbank.dao.MoneyDao;
import ru.kuper.ironbank.service.GlobalBankService;

/**
 * @author Ilya V. Kupriyanov
 * @version 06.03.2022
 */
@Configuration
@RequiredArgsConstructor
public class AppConfig {

    @Autowired
    private final MoneyDao moneyDao;

    @Scope("singleton")
    @Bean
    public GlobalBankService globalBankVars() {
        return new GlobalBankService(moneyDao);
    }

}
