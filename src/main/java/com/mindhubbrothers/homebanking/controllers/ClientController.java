package com.mindhubbrothers.homebanking.controllers;


import com.mindhubbrothers.homebanking.dtos.ClientDTO;
import com.mindhubbrothers.homebanking.models.Client;
import com.mindhubbrothers.homebanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;



    @RequestMapping("/clients")
    public List<ClientDTO> getClients(){

        List<Client> listClient = clientRepository.findAll();

        List<ClientDTO> listClientDTO =
                listClient
                        .stream()
                        .map(client -> new ClientDTO(client))
                        .collect(Collectors.toList());

        return listClientDTO;
    }


    @RequestMapping("/clients/{valor}")
        public ClientDTO getClient(@PathVariable Long valor){
            return new ClientDTO(clientRepository.findById(valor).orElse(null));
        }

}
