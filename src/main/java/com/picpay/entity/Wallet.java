package com.picpay.entity;


import com.picpay.utils.TypeWallet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name = "wallet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpf;

    private BigDecimal balance;

    private String email;

    private TypeWallet typeWallet;

    public Wallet debit(BigDecimal value) {
        return new Wallet(this.id, this.name, this.cpf, this.balance
                .subtract(value), this.email, this.typeWallet);
    }

    public Wallet credit(BigDecimal value) {
        return new Wallet(this.id, this.name, this.cpf, this.balance
                .add(value), this.email, this.typeWallet);
    }


}
