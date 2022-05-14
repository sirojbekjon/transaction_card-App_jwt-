package com.example.transaction_card_jwt.repository;

import com.example.transaction_card_jwt.intity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser,Integer> {
}
