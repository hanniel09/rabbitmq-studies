package org.hanniel.api;

import org.hanniel.Facade.ResponseFacade;
import org.hanniel.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/response")
public class Response {

    @Autowired
    ResponseFacade responseFacade;

    @PostMapping
    public String process(@RequestBody ResponseDTO responseDTO){
        return responseFacade.RequestResponse(responseDTO);
    }
}
