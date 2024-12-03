package tn.iteam.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tn.iteam.entities.Customer;
import tn.iteam.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerRestController {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();
        if (allCustomers.isEmpty()) {
            throw new RuntimeException("No Customer found");
        }
        return allCustomers;
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") Long id) {
        Customer customer = customerRepository.findById(id).get();
        if (customer.equals(null)) {
            throw new RuntimeException("No Customer found");
        }
        return customer;
    }
}
