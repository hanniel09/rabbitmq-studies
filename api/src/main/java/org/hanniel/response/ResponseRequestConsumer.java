package org.hanniel.response;

import org.hanniel.Facade.ResponseFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ResponseRequestConsumer {

    @Autowired
    ResponseFacade responseFacade;

    @RabbitListener(queues = {"response_success_queue"})
    public void receive(@Payload Message message){
        String payload = String.valueOf(message.getPayload());
        responseFacade.responseStatus(payload);
    }
}
