package com.mindhubbrothers.homebanking.dtos;

import com.mindhubbrothers.homebanking.models.Account;

import java.time.LocalDate;

public class AccountDTO {
    //atributos
    private Long id;
    private String number;

    private LocalDate localDate;

    private double balance;

    //Constructor
    public AccountDTO(Account account){
        id = account.getId();
        number = account.getNumber();
        localDate = account.getLocalDate();
        balance = account.getBalance();

    }

    //Metodos

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public double getBalance() {
        return balance;
    }
}
