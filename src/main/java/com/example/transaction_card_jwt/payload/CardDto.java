package com.example.transaction_card_jwt.payload;

import lombok.Data;

import java.util.Date;

@Data
public class CardDto {

    private String number;

    private float balance;

    private Integer user_id;

}
