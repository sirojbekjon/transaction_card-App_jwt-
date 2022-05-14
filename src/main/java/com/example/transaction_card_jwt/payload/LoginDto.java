package com.example.transaction_card_jwt.payload;


import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String password;
}
