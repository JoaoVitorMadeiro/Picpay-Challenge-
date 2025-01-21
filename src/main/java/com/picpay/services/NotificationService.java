package com.picpay.services;

import com.picpay.client.NotificationClient;
import com.picpay.entity.Transfer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@AllArgsConstructor
public class NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);
    private final NotificationClient notificationClient;


    public void sendNotification(Transfer transfer) {
        try {
            logger.info("Sending notification");

            var res = notificationClient.sendNotification(transfer);

            if(res.getStatusCode().isError())
            {
                logger.error("Error while sending notification, status code is not OK");
            }

        } catch (Exception e) {
            logger.error("Error while sending notification", e);
        }
    }
}
