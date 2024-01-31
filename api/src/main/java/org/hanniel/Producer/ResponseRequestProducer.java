package org.hanniel.Producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hanniel.dto.ResponseDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResponseRequestProducer {

    @Autowired
    AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void toIntegrate(ResponseDTO responseDTO) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                "response_exchange",
                "response_rout_key",
                objectMapper.writeValueAsString(responseDTO)
        );
    }
}
