package com.example.transaction_card_jwt.controller;


import com.example.payload.LoginDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/report")
public class ReportController {


    @GetMapping
    public HttpEntity<?> getReports(){
        return ResponseEntity.ok("Report sent");
    }

    @PostMapping("/test")
    public HttpEntity<?>addTest(@RequestBody LoginDto loginDto){
        System.out.println(loginDto);
        return ResponseEntity.ok(loginDto);
    }
}
