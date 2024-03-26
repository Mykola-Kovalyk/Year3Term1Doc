package com.lpnu.iot.cornerstoneondemand.structure.controllers;

import com.lpnu.iot.cornerstoneondemand.resources.ClientCard;
import com.lpnu.iot.cornerstoneondemand.structure.services.ClientCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientCardController {

    @Autowired
    private ClientCardService clientCardService;

    @GetMapping(path = "client-cards/{cardId}")
    public ClientCard getClientCard(@PathVariable Long cardId) {
        return clientCardService.getClientCard(cardId);
    }
}
