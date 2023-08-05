package com.mindhubbrothers.homebanking;

import com.mindhubbrothers.homebanking.models.Client;
import com.mindhubbrothers.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(ClientRepository clientRepository){
		return args ->{

			Client client = new Client("Ezequiel","Castro Gramajo","eze@gmail.com");
			Client client1 = new Client("Lionel","Messi","leomessi@mundial.com");

			System.out.println(client);
			clientRepository.save(client);
			clientRepository.save(client1);
			System.out.println(client1);

		};
	}
}
