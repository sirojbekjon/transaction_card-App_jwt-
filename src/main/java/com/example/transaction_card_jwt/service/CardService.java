package com.example.transaction_card_jwt.service;


import com.example.transaction_card_jwt.intity.Card;
import com.example.transaction_card_jwt.intity.MyUser;
import com.example.transaction_card_jwt.payload.CardDto;
import com.example.transaction_card_jwt.repository.CardRepository;
import com.example.transaction_card_jwt.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    MyUserRepository myUserRepository;

    public HttpEntity<?> addCards(CardDto cardDto){
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
        Card card = new Card();
        card.setNumber(cardDto.getNumber());
        card.setBalance(cardDto.getBalance());
        card.setActive(true);
        card.setExpireDate(new Date());
        Optional<MyUser> myUser = myUserRepository.findById(cardDto.getUser_id());
        MyUser myUser1 = myUser.get();
        card.setUser(myUser1);
        cardRepository.save(card);
        return ResponseEntity.status(200).body("Saqlandi");
    }
}

//    public int status = 0;
//    public float sum=0;

//
//    public String Transend(Card card){
//        System.out.println("sizning mablagingiz:"+card.getMoney());
//        sum = (float) ((0.01 * card.getSendMoney()) + card.getSendMoney());
//        if (card.getSendMoney()>0){
//            if (card.getMoney() > 0 && card.getMoney() > sum){
//                card.setMoney((float) (card.getMoney()-sum));
//                status = 1;
//            }
//            else {
//               return "Mablag' yetarli emas";
//            }
//           return "Qolgan pul miqdori: "+card.getMoney();
//        }
//        else if (0 < card.getInviteMoney()){
//            card.setMoney(card.getMoney() + card.getInviteMoney());
//            status = 2;
//            return "Sizning hisobingizdagi pul miqdori: "+card.getMoney();
//        }
//
//       return "Avval O'tkazma yohud qabul qilinadigan pul miqdorini kiriting";
//    }
//
//
//    public List<String> HistoryCard(Card card){
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        if (status==1) {
//            List<String> historycard = new ArrayList<>();
//
//            historycard.add("O'tkazilgan pul miqdori: " + card.getSendMoney());
//            historycard.add("Qolgan pul qoldigi: " + card.getMoney());
//            historycard.add("o'tkazilgan plastik raqami: " + card.getSendCardNumber());
//            historycard.add("O'tqazilgan sana: "+dtf.format(now));
//
//            System.out.println( "Sizning kartangiz tarixi:\n" + historycard);
//            return historycard;
//        }
//        else if(status==2){
//            List <String> historycard = new ArrayList<>();
//
//            historycard.add("Qabul qilingan pul miqdori: " + card.getInviteMoney());
//            historycard.add("Sizning Hisobingizdagi pul miqdori: " + card.getMoney());
//            historycard.add("o'tkazilgan plastik raqami: " + card.getInviteCardNumber());
//            historycard.add("Qabul qilingan sana: "+dtf.format(now));
//
//            System.out.println("Sizning kartangiz tarixi:\n" + historycard);
//        }else
//        {
//            System.out.println("Sizning kartangiz bilan o'tkazmalar amalga oshirilmagan");
//        }
//
//        return null;
//
//    }
//
//
//}
