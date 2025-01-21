package com.picpay.client;

import com.picpay.entity.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification", url = "${notification.url}")
public interface NotificationClient {

    @PostMapping("/notification")
    ResponseEntity<Void> sendNotification(@RequestBody Transfer transfer);

}
