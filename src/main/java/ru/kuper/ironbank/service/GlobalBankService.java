package ru.kuper.ironbank.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kuper.ironbank.dao.MoneyDao;
import ru.kuper.ironbank.model.Bank;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * @author Ilya V. Kupriyanov
 * @version 06.03.2022
 */
@Component
@Data
@RequiredArgsConstructor
public class GlobalBankService {
    @Autowired
    private final MoneyDao moneyDao;

    private Bank bank;

    private Long bankAmount;

    @PostConstruct
    private void initialize() {
        setBankEntity();
        Bank bank = getBank();
        bank.setBalance(1_000_000L);
        Bank saved = moneyDao.save(bank);
        System.out.println(String.format("Bank initialization provided; Bank balance : %s", saved.getBalance()));
        setBankAmount(saved.getBalance());
    }

    public Long issue(Long value, String targetName) {
        Bank bank = getBank();
        bank.setBalance(bank.getBalance() - value);
        Bank saved = moneyDao.save(bank);
        setBankAmount(saved.getBalance());
        System.out.println(String.format("Bank account subtracted value: %s; current balance: %s",value, saved.getBalance()));
        Optional<Bank> targetCandidate = moneyDao.findByName(targetName);
        if (targetCandidate.isEmpty()) throw new IllegalArgumentException("Target not found!");
        Bank target = targetCandidate.get();
        target.setBalance(target.getBalance() + value);
        moneyDao.save(target);
        return bank.getBalance();
    }

    public Long retrieve(Long value, String targetName) {
        Bank bank = getBank();
        bank.setBalance(bank.getBalance() + value);
        Bank saved = moneyDao.save(bank);
        setBankAmount(saved.getBalance());
        System.out.println(String.format("Bank account summarized value: %s; current balance: %s",value, saved.getBalance()));
        Optional<Bank> targetCandidate = moneyDao.findByName(targetName);
        if (targetCandidate.isEmpty()) throw new IllegalArgumentException("Target not found!");
        Bank target = targetCandidate.get();
        target.setBalance(target.getBalance() - value);
        moneyDao.save(target);
        return bank.getBalance();
    }

    private void setBankEntity() {
        Optional<Bank> braavosBankCandidate = moneyDao.findByName("Braavos Bank");
        if (braavosBankCandidate.isPresent()) {
            setBank(braavosBankCandidate.get());
        } else {
            Bank braavosBank = moneyDao.save(new Bank("Braavos Bank", 1_000_000L));
            setBank(braavosBank);
        }
    }

}
