package com.example.transaction_card_jwt.controller;


import com.example.transaction_card_jwt.intity.MyUser;
import com.example.transaction_card_jwt.intity.OutCome;
import com.example.transaction_card_jwt.model.Card;
import com.example.transaction_card_jwt.payload.CardDto;
import com.example.transaction_card_jwt.payload.IncomeDto;
import com.example.transaction_card_jwt.payload.OutComeDto;
import com.example.transaction_card_jwt.repository.OutComeRepository;
import com.example.transaction_card_jwt.service.CardService;
import com.example.transaction_card_jwt.service.IncomeService;
import com.example.transaction_card_jwt.service.MyUserService;
import com.example.transaction_card_jwt.service.OutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;

    @Autowired
    OutcomeService outcomeService;

    @Autowired
    IncomeService incomeService;

    @PostMapping("/addcard")
    public HttpEntity<?> addcard(@RequestBody CardDto cardDto){
        HttpEntity<?> httpEntity = cardService.addCards(cardDto);
        return httpEntity;
    }

    @PostMapping("/income")
    public HttpEntity<?> incomeMoney(@RequestBody IncomeDto incomeDto){
        HttpEntity<?> httpEntity = incomeService.incomeMoneySend(incomeDto);
        return httpEntity;
    }

    @PostMapping("/outcome")
    public HttpEntity<?> outcomeMoney(@RequestBody OutComeDto outComeDto){
        HttpEntity<?> httpEntity = outcomeService.addOutCome(outComeDto);
        return httpEntity;
    }


}
