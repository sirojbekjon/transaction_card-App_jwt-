package com.example.transaction_card_jwt.payload;

import com.example.transaction_card_jwt.intity.Card;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class IncomeDto {

    private Integer fromCard_id;

    private Integer toCard_id;

    private float amount;
}
