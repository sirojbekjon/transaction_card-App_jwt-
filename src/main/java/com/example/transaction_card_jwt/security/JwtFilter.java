package com.example.transaction_card_jwt.security;

import com.example.transaction_card_jwt.service.MyAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    MyAuthService myAuthService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        //REQUESTDAN TOKENNI OLISH
       String token = httpServletRequest.getHeader("Authorization");

       //TOKEN BORLIGINI VA TOKENNING BOSHLANISHI BEARER BO'LISHINI TEKSHIRYAPMIZ
        if (token != null && token.startsWith("Bearer")){

            //AYNAN TOKENNI O'ZINI QIRQIB OLDIK
            token = token.substring(7);

            //TOKENNI VALIDATSIADAN O'TKAZDIK (TOKEN BUZILGANMI YUQMIO MUDDATINI TEKSHIRDIK)
            boolean validateToken = jwtProvider.validateToken(token);
            if (validateToken){

                //TOKENNI ICHIDAN USERNAMENI OLDIK
                String userNameFromToken = jwtProvider.getUserNameFromToken(token);

                //USERNAME ORQALI USERDETAILSNI OLDIK
                UserDetails userDetails = myAuthService.loadUserByUsername(userNameFromToken);

                //USERDETAILS ORQALI AUTHENTICATION YARATIB OLDIK
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());
                System.out.println(SecurityContextHolder.getContext().getAuthentication());

                //SESTEMAGA KIM KIRGANLIGINI O'RNATIB QOYDIK
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            }
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);

    }
}
