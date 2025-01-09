package com.picpay.client;

import com.picpay.dto.AuthorizationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "authorization", url = "${authorization.url}")
public interface AuthorizationClient {

    @GetMapping("/authorization")
    ResponseEntity<AuthorizationResponse> isAuthorized();


}
