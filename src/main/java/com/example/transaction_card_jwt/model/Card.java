package com.example.transaction_card_jwt.model;

import org.springframework.web.bind.annotation.RestController;

public class Card {

    private float money;

    private float sendMoney;

    private float inviteMoney;

    private String sendCardNumber;

    private String inviteCardNumber;

    public Card(float money, float sendMoney, String sendCardNumber) {
        this.money = money;
        this.sendMoney = sendMoney;
        this.sendCardNumber=sendCardNumber;
    }

    public Card(float money, String inviteCardNumber, float inviteMoney) {
        this.money = money;
        this.inviteMoney = inviteMoney;
        this.inviteCardNumber = inviteCardNumber;
    }

    public Card() {
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public float getSendMoney() {
        return sendMoney;
    }

    public void setSendMoney(float sendMoney) {
        this.sendMoney = sendMoney;
    }


    public String getSendCardNumber() {
        return sendCardNumber;
    }

    public void setSendCardNumber(String sendCardNumber) {
        this.sendCardNumber = sendCardNumber;
    }


    public float getInviteMoney() {
        return inviteMoney;
    }

    public void setInviteMoney(float inviteMoney) {
        this.inviteMoney = inviteMoney;
    }

    public String getInviteCardNumber() {
        return inviteCardNumber;
    }

    public void setInviteCardNumber(String inviteCardNumber) {
        this.inviteCardNumber = inviteCardNumber;
    }
}

