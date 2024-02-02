package org.hanniel.worker.consumer;

import org.hanniel.worker.producer.ResponseSuccessProducer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ResponseConsumer {

    @Autowired
    ResponseSuccessProducer responseSuccessProducer;

    @RabbitListener(queues = "response_queue")
    public void receiverMessage(@Payload Message message){
        System.out.println(message);
        responseSuccessProducer.generateResponse("Response " + message);
    }
}
