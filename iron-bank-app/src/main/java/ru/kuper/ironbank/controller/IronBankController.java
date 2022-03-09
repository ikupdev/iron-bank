package ru.kuper.ironbank.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kuper.ironbank.dao.MoneyDao;
import ru.kuper.ironbank.model.Bank;
import ru.kuper.ironbank.service.TransferMoneyService;

import java.util.Optional;

import static java.lang.String.format;

/**
 * @author Ilya V. Kupriyanov
 * @version 06.03.2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping
public class IronBankController {
    private final TransferMoneyService transferMoneyService;
    private final MoneyDao moneyDao;

    @GetMapping("/credit")
    public String credit(@RequestParam String name, @RequestParam long amount) {
        long resultDeposit = transferMoneyService.transfer(name, amount);
        if (resultDeposit == -1) {
            return "Rejected<br/>" + name + " <b>will't</b> survive this winter";
        }
        return format("<i>Credit approved for %s</i> <br/>Current bank balance: <b>%s</b>", name, resultDeposit);
    }

    @GetMapping("/state")
    public long currentState(){
        Optional<Bank> byId = moneyDao.findById(1L);
        return byId.get().getBalance();  //todo correct!
    }

}
