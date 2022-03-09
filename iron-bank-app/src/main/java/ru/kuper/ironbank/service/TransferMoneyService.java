package ru.kuper.ironbank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuper.ironbank.dao.MoneyDao;
import ru.kuper.ironbank.model.Bank;
import ru.kuper.ironbank.model.ProphetProperties;

import java.util.Optional;

/**
 * @author Ilya V. Kupriyanov
 * @version 06.03.2022
 */
@Service
@RequiredArgsConstructor
public class TransferMoneyService {
    private final GlobalBankService globalBankService;
    private final MoneyDao moneyDao;
    private final ProphetProperties prophetProperties;
    private final NameBasedProphetService nameBasedProphetService;

    public long transfer(String targetName, long amount) {
        Optional<Bank> bankEntry = moneyDao.findByName(targetName);
        if (targetName.equals("Braavos Bank")) {
            throw new IllegalArgumentException("target name is Braavos Bank! It is not correct;");
        }
        if (bankEntry.isEmpty()) {
            throw new IllegalArgumentException("Client does not exist!");
        }
        if (prophetProperties.getReturning().stream().noneMatch(s -> bankEntry.get().getName().equals(s))) {
            return -1;
        } else {
            if (nameBasedProphetService.willSurvive(targetName)) {
                return globalBankService.issue(amount, targetName);
            }
            return -1;
        }
    }
}