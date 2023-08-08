package com.mindhubbrothers.homebanking.controllers;

import com.mindhubbrothers.homebanking.dtos.AccountDTO;
import com.mindhubbrothers.homebanking.dtos.ClientDTO;
import com.mindhubbrothers.homebanking.models.Account;
import com.mindhubbrothers.homebanking.models.Client;
import com.mindhubbrothers.homebanking.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping("/accounts")
    public List<AccountDTO> getAccounts(){
        List<Account> listAccount = accountRepository.findAll();

        List<AccountDTO> listAccountDTO =
                listAccount.stream().map(account -> new AccountDTO(account)).collect(Collectors.toList());

        return listAccountDTO;
    }

}

