package com.example.transaction_card_jwt.service;


import com.example.transaction_card_jwt.intity.MyUser;
import com.example.transaction_card_jwt.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MyUserService {

    @Autowired
    MyUserRepository myUserRepository;

    public HttpEntity<?> addUser(MyUser myUser){
        MyUser myUser1 = new MyUser();
        myUser1.setName(myUser.getName());
        myUser1.setPassword(myUser.getPassword());
        myUserRepository.save(myUser1);
        return ResponseEntity.status(200).body("saqlandi");
    }

}
