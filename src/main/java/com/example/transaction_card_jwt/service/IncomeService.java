package com.example.transaction_card_jwt.service;

import com.example.transaction_card_jwt.intity.Card;
import com.example.transaction_card_jwt.intity.Income;
import com.example.transaction_card_jwt.intity.MyUser;
import com.example.transaction_card_jwt.payload.IncomeDto;
import com.example.transaction_card_jwt.repository.CardRepository;
import com.example.transaction_card_jwt.repository.IncomeRepository;
import com.example.transaction_card_jwt.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class IncomeService {

    @Autowired
    IncomeRepository incomeRepository;

    @Autowired
    CardRepository cardRepository;
    public HttpEntity<?> incomeMoneySend(IncomeDto incomeDto){
        Income income = new Income();

        income.setAmount(incomeDto.getAmount());
        Optional<Card> optionalCard = cardRepository.findById(incomeDto.getToCard_id());
        Card card = optionalCard.get();
        income.setToCard(card);
        Optional<Card> optionalCard1 = cardRepository.findById(incomeDto.getFromCard_id());
        Card card1 = optionalCard1.get();
        income.setFromCard(card1);

        income.setDate(new Date());
        Income save = incomeRepository.save(income);
        return ResponseEntity.status(200).body("saqlandi");
    }

}
