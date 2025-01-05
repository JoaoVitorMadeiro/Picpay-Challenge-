package com.picpay.repositories;

import com.picpay.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Wallet findByCpf(String cpf);
    Wallet findByEmail(String email);
}
