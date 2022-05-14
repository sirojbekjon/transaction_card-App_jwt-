package com.example.transaction_card_jwt.service;

import com.example.transaction_card_jwt.intity.Card;
import com.example.transaction_card_jwt.intity.OutCome;
import com.example.transaction_card_jwt.payload.OutComeDto;
import com.example.transaction_card_jwt.repository.CardRepository;
import com.example.transaction_card_jwt.repository.OutComeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OutcomeService {

    @Autowired
    OutComeRepository outComeRepository;

    @Autowired
    CardRepository cardRepository;
    public HttpEntity<?> addOutCome(OutComeDto outComeDto){
        OutCome outCome1 = new OutCome();
        outCome1.setAmount(outComeDto.getAmount());
        outCome1.setComissionAmount(2.2f);
        outCome1.setDate(new Date());

        Optional<Card> optionalCard = cardRepository.findById(outComeDto.getFromCard_id());
        Card card = optionalCard.get();
        outCome1.setFromCard(card);

        Optional<Card> cardOptional1 = cardRepository.findById(outComeDto.getToCard_id());
        Card card1 = cardOptional1.get();
        outCome1.setToCard(card1);


        OutCome save = outComeRepository.save(outCome1);
        return ResponseEntity.status(200).body("saqlandi");
    }

}
