package com.mindhubbrothers.homebanking.dtos;

import com.mindhubbrothers.homebanking.models.Account;
import com.mindhubbrothers.homebanking.models.Transaction;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountDTO {
    //atributos
    private Long id;
    private String number;

    private LocalDate localDate;

    private double balance;

    private Set<TransactionDTO> transactions;



    //Constructor
    public AccountDTO(Account account){
        id = account.getId();
        number = account.getNumber();
        localDate = account.getLocalDate();
        balance = account.getBalance();
        transactions = account.getTransactions().stream().map(element-> new TransactionDTO(element)).collect(Collectors.toSet());


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

    public Set<TransactionDTO> getTransactions() {
        return transactions;
    }
}
