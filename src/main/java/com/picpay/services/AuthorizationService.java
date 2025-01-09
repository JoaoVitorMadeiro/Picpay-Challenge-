package com.picpay.services;

import com.picpay.client.AuthorizationClient;
import com.picpay.dto.TransferDto;
import com.picpay.exception.PicPayException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorizationService {
    @Autowired
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