package tn.iteam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.iteam.entities.Customer;
import tn.iteam.repositories.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
        System.out.println("Customer Service started");
    }
    //insertion des donnee
    @Bean
    public CommandLineRunner init(CustomerRepository customerRepository) {
        return args -> {
            Customer c1 = new Customer();
            c1.setFirstName("John");
            c1.setLastName("Smith");
            c1.setEmail("john.smith@gmail.com");
            customerRepository.save(c1);
            Customer c2 = new Customer();
            c2.setFirstName("John");
            c2.setLastName("Smith");
            c2.setEmail("john.smith@gmail.com");
            customerRepository.save(c2);
        };
    }
    //fin d insertion
}
