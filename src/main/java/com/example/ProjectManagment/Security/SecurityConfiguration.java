package com.example.ProjectManagment.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http ) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
//                              .anyRequest().authenticated();
                                .requestMatchers("/projects/new").hasRole("ADMIN")
                                .requestMatchers("/projects/save").hasRole("ADMIN")
                                .requestMatchers("/Employee/new").hasRole("ADMIN")
                                .requestMatchers("/Employee/save").hasRole("ADMIN")
                                .requestMatchers("/home").authenticated()
                                .requestMatchers("/home","/**").permitAll()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(form-> form.loginPage("/Loginpages"));

        return http.build();
    }

@Bean
public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig, DataSource dataSource) throws Exception {
    JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
    userDetailsManager.setUsersByUsernameQuery("SELECT username, password, enabled FROM user_accounts WHERE username = ?");
    userDetailsManager.setAuthoritiesByUsernameQuery("SELECT username, role FROM user_accounts WHERE username = ?");

    return authConfig.getAuthenticationManager();
}

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        BCryptPasswordEncoder bycriptpass = new BCryptPasswordEncoder();
        return bycriptpass;
    }
}



