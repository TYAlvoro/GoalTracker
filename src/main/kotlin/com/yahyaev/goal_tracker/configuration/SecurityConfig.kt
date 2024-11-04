package com.yahyaev.goal_tracker.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { requests ->
                requests
                    .requestMatchers("/").permitAll()  // Разрешить доступ к этим URL без авторизации
                    .anyRequest().authenticated()  // Требовать авторизацию для остальных URL
            }
            .formLogin { form ->
                form
                    .loginPage("/login")  // Укажите свою страницу логина, если хотите
                    .permitAll()
            }
            .logout { logout ->
                logout.permitAll()
            }
        return http.build()
    }
}
