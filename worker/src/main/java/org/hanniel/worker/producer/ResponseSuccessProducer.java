package org.hanniel.worker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseSuccessProducer {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void generateResponse(String message){
        amqpTemplate.convertAndSend(
                "response_success_exchange",
                "response_success_rout_key",
                message
        );
    }

}
