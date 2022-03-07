package ru.kuper.ironbank.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kuper.ironbank.model.Bank;

import java.util.Optional;

/**
 * @author Ilya V. Kupriyanov
 * @version 06.03.2022
 */
@Repository
public interface MoneyDao extends CrudRepository<Bank, Long> {
    Optional<Bank> findByName(String name);
}
