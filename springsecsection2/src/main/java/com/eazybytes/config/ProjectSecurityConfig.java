package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        /**
         * Below is the custom security configurations
         */

        http.authorizeHttpRequests((requests) -> {
                requests.requestMatchers("/myAccount", "/myBalance", "myLoans", "myCards").authenticated();
                requests.requestMatchers("/contact", "notices").permitAll();
        });
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return http.build();

        /**
         * Configuration to deny all the requests
         */

        /*http.authorizeHttpRequests((requests) -> {
            requests.anyRequest().denyAll();
        });
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return http.build();*/

        /**
         * Configuration to permit all the requests
         */

        /*http.authorizeHttpRequests((requests) -> {
            requests.anyRequest().permitAll();
        });
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return http.build();*/
    }
}
