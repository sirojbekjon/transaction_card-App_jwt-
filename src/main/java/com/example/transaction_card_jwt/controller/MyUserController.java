package com.example.transaction_card_jwt.controller;

import com.example.transaction_card_jwt.intity.MyUser;
import com.example.transaction_card_jwt.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/MyUser")
public class MyUserController {

    @Autowired
    MyUserService myUserService;



    @PostMapping("/user")
    public HttpEntity<?> postUser(@RequestBody MyUser myUser){
        HttpEntity<?> httpEntity = myUserService.addUser(myUser);
        return httpEntity;
    }

}
