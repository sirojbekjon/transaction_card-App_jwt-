package com.example.transaction_card_jwt.intity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private MyUser user;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private Date expireDate;

    @Column(nullable = false)
    private float balance;

    private boolean active;

}
