package org.hanniel.Facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.hanniel.Producer.ResponseRequestProducer;
import org.hanniel.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseFacade {

    @Autowired
    ResponseRequestProducer response;

    public String RequestResponse(ResponseDTO responseDTO){
        try{
            response.toIntegrate(responseDTO);
        } catch (JsonProcessingException e) {
            return "error to request response" + e.getMessage();
        }
        return "await response";
    }

    public void responseStatus(String response){
        System.out.println("RESPONSE : " + response);
    }
}
