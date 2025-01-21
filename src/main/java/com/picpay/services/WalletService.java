package com.picpay.services;


import com.picpay.dto.CreateWalletDto;
import com.picpay.dto.TransferDto;
import com.picpay.entity.Wallet;
import com.picpay.exception.WalletDataAlreadyExistsException;
import com.picpay.exception.WalletNotFoundException;
import com.picpay.repositories.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WalletService {


    private final WalletRepository walletRepository;

    public Wallet createWallet(CreateWalletDto dto) {

        var walletdb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());

        if(walletdb.isPresent())
        {
            throw new WalletDataAlreadyExistsException("Cpf/Cnpj or email already exists");
        }

        return walletRepository.save(dto.toWallet());
    }
}
