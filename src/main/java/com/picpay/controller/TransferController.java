package com.picpay.controller;


import com.picpay.dto.TransferDto;
import com.picpay.entity.Transfer;
import com.picpay.services.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/Transfer")
    public ResponseEntity<Transfer> transfer(@RequestBody TransferDto dto){
        var res = transferService.transfer(dto);

        return ResponseEntity.ok(res);
    }
}

