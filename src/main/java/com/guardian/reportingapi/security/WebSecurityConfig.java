package com.guardian.reportingapi.security;

import com.guardian.reportingapi.security.jwt.JwtTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenFilter jwtTokenFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // CSRF korumasını devre dışı bırak
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless oturum yönetimi
                .and()
                .authorizeRequests()
                .antMatchers("/h2-console/**").permitAll() // H2 konsoluna izin ver
                .antMatchers("/api/v3/merchant/user/login").permitAll()
                .antMatchers("/css/**", "/js/**", "/images/**", "/login.html", "/favicon.ico", "/main.html").permitAll()
                .antMatchers("/api/v3/transaction/report").permitAll()
                .antMatchers("/api/v3/transaction/list").permitAll()
                .anyRequest().authenticated() // Diğer her istek için kimlik doğrulaması gerektir
                .and()
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class); // JWT filtresini ekle

        http.headers().frameOptions().disable(); // H2 konsolu için frame seçeneklerini devre dışı bırak
    }
}