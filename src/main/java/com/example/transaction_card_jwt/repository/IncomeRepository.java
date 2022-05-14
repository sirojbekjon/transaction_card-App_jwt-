package com.example.transaction_card_jwt.repository;

import com.example.transaction_card_jwt.intity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income,Integer> {
}
