package com.picpay.services;

import com.picpay.client.AuthorizationClient;
import com.picpay.dto.TransferDto;
import com.picpay.exception.PicPayException;
import lombok.AllArgsConstructor;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Configuration
@EnableFeignClients(basePackages = "com.picpay.client")
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public boolean isAuthorized(TransferDto transfer) {
        var res = authorizationClient.isAuthorized();

        if(res.getStatusCode().isError())
        {
            throw new PicPayException();
        }

        return  res.getBody().authorized();
    }
}