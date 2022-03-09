package ru.kuper.ironbank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Ilya V. Kupriyanov
 * @version 06.03.2022
 */
@Entity
@Table(name = "bank")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Bank extends BaseEntity {
    private String name;
    private Long balance;
}
