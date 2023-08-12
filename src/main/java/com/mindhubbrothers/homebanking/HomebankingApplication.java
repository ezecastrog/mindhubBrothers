package com.mindhubbrothers.homebanking;

import com.mindhubbrothers.homebanking.models.Account;
import com.mindhubbrothers.homebanking.models.Client;
import com.mindhubbrothers.homebanking.models.Transaction;
import com.mindhubbrothers.homebanking.models.TransactionType;
import com.mindhubbrothers.homebanking.repositories.AccountRepository;
import com.mindhubbrothers.homebanking.repositories.ClientRepository;
import com.mindhubbrothers.homebanking.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(ClientRepository clientRepository, AccountRepository accountRepository){
		return args ->{

			//Crear la persona
			Client client1 = new Client("Melba","Morel","melba@mindhub.com");
			Client client2 = new Client("Lionel","Messi","leomessi@mundial.com");

			//Guardar en base de datos la persona
			clientRepository.save(client1);
			clientRepository.save(client2);

			System.out.println(client2);
			System.out.println(client1);

			//Crear la cuenta
            Account account1 = new Account();
            account1.setNumber("VIN001");
			account1.setBalance(5000.0);
			account1.setLocalDate(LocalDate.now());

			Account account2 = new Account();
			account2.setNumber("VIN002");
			account2.setBalance(7500.0);
			account2.setLocalDate(LocalDate.now().plusMonths(1));

			Account account3 = new Account();
			account3.setNumber("VIN003");
			account3.setBalance(3000.0);
			account3.setLocalDate(LocalDate.now());

			//Agregar la cuenta a la persona
			client1.addAccount(account1);
			client1.addAccount(account2);
			client2.addAccount(account3);


			//Guardo la cuenta en la base de datos
            accountRepository.save((account1));
			accountRepository.save((account2));
			accountRepository.save((account3));

			//Crear transaccion
			Transaction transaction1 = new Transaction();
			transaction1.setDescription("Envio monto para pago servicios");
			transaction1.setLocalDate(LocalDate.now());
			transaction1.setType(TransactionType.DEBIT);
			transaction1.setAmount(1000);

			//Agrego la transaccion a la cuenta
			account1.addTransaction(transaction1);

			//Guardo la transaccion en la base


		};
	}
}
