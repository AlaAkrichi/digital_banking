package tn.iteam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.iteam.entities.BankAccount;
import tn.iteam.enums.TypeCompte;
import tn.iteam.repositories.AccountRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    //insertion des donnee
    @Bean
    public CommandLineRunner init(AccountRepository accountsRepository) {    return args -> {
        List<BankAccount> accountList =
                List.of( BankAccount.builder()
                                .AccountId(UUID.randomUUID().toString())
                                .currency("DTN")
                                .balance(Math.random() * 90000)
                                .createdAt(LocalDate.now())
                                .type(TypeCompte.SAVING_ACCOUNT)
                                .customerId(Long.valueOf(1))
                                .build(),
                        BankAccount.builder()
                                .AccountId(UUID.randomUUID().toString())
                                .currency("DTN")
                                .balance(Math.random() * 90000)
                                .createdAt(LocalDate.now())
                                .type(TypeCompte.SAVING_ACCOUNT)
                                .customerId(Long.valueOf(2))
                                .build()        );
        accountsRepository.saveAll(accountList);
    };
    }

    //fin d insertion

}
