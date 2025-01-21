package com.picpay.controller;


import com.picpay.dto.CreateWalletDto;
import com.picpay.entity.Wallet;
import com.picpay.services.WalletService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @PostMapping("/create")
    public ResponseEntity<Wallet> createWallet(@RequestBody @Valid CreateWalletDto dto){
        var wallet = walletService.createWallet(dto);
        return ResponseEntity.ok(wallet);
    }
}
