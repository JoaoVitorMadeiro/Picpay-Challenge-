package com.picpay.dto;

import com.picpay.entity.Wallet;
import com.picpay.entity.WalletType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateWalletDto(
        @NotBlank String fullname,
        @NotBlank String cpfCnpj,
        @NotBlank String email,
        @NotBlank String password,
        @NotNull WalletType.WalletTypeEnum walletType) {
    public Wallet toWallet(){
        return new Wallet(
                fullname,
                cpfCnpj,
                email,
                password,
                walletType
        );
    }
}