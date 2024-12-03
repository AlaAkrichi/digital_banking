package tn.iteam.entities;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;
import tn.iteam.enums.TypeCompte;
import tn.iteam.models.Customer;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BankAccount {
    @Id
    private String AccountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING) // bch twali string ( saving wala curent )
    private TypeCompte type;
    @Transient
    private Customer customer;
    private Long customerId;
}
