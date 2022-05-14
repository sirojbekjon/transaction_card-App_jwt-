package com.example.transaction_card_jwt.config;


import com.example.transaction_card_jwt.security.JwtFilter;
import com.example.transaction_card_jwt.service.MyAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyAuthService myAuthService;

    @Autowired
    JwtFilter jwtFilter;


    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(myAuthService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/","/api/auth/login").permitAll()
                .anyRequest().authenticated();

        //SPRING SECURITYGA UsernamePasswordAuthenticationFilter.class DAN OLDIN jwtFilter ISHLASHNI AYTYAPTI
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        //SPRING SECURITYGA SESSIAGA USHLAB QOLMASLIGINI BUYURMOQDA
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
