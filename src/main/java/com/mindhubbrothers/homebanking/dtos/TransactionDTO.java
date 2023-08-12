package com.mindhubbrothers.homebanking.dtos;

import com.mindhubbrothers.homebanking.models.Transaction;
import com.mindhubbrothers.homebanking.models.TransactionType;

import java.time.LocalDate;

public class TransactionDTO {

    //atributos

    private Long id;

    private TransactionType type;

    private String description;

    private double amount;

    private LocalDate localDate;

    //Constructor
    public TransactionDTO(Transaction transaction){
        id = transaction.getId();
        type = transaction.getType();
        description = transaction.getDescription();
        amount = transaction.getAmount();
        localDate = transaction.getLocalDate();
    }



    //Metodos
    public Long getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
}
