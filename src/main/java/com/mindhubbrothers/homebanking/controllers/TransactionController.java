package com.mindhubbrothers.homebanking.controllers;


import com.mindhubbrothers.homebanking.dtos.TransactionDTO;
import com.mindhubbrothers.homebanking.models.Transaction;
import com.mindhubbrothers.homebanking.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;

     @RequestMapping("/transaction")

        public List<TransactionDTO> getTransactions(){
             List<Transaction> listTransaction = transactionRepository.findAll();

             List<TransactionDTO> listTransactionDTO =
                     listTransaction.stream().map(transaction -> new TransactionDTO(transaction)).collect(Collectors.toList());
         return listTransactionDTO;
     }




     }
