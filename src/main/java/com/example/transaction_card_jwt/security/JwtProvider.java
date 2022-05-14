package com.example.transaction_card_jwt.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {


    static long expireTime = 36_000_000;
static String secretkey = "BuKalitsozBolibTokenGeneratsiyasiUchunIshlatilgan";
public  String generateToken(String username){

    Date expireDate = new Date(System.currentTimeMillis()+expireTime);
    String token = Jwts
            .builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(expireDate)
            .signWith(SignatureAlgorithm.HS512, secretkey)
            .compact();

        return token;
}

        public boolean validateToken(String token){
            try {

                 Jwts
                    .parser()
                    .setSigningKey(secretkey)
                    .parseClaimsJws(token);
                    return true;
                 }
             catch (Exception e){
                     e.printStackTrace();
                         }return false;
}

        public String getUserNameFromToken(String token){
            String username = Jwts
                    .parser()
                    .setSigningKey(secretkey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        return username;

        }
        }
