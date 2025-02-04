package com.example.ProjectManagment.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http ) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().authenticated(); هر درخواستی که فرستاده میشود را احراز هویت کن
                                .requestMatchers("/projects/new").hasRole("ADMIN")
                                .requestMatchers("/projects/save").hasRole("ADMIN")
                                .requestMatchers("/Employee/new").hasRole("ADMIN")
                                .requestMatchers("/Employee/save").hasRole("ADMIN")// مسیرهای مدیریت
                                .requestMatchers("/home").authenticated() // مسیرهایی که نیاز به لاگین دارند
                                .requestMatchers("/home","/**").permitAll() // سایر مسیرها عمومی
                )
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity https, DataSource dataSource) throws Exception {
        AuthenticationManagerBuilder authBuilder = https.getSharedObject(AuthenticationManagerBuilder.class);
        authBuilder
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled FROM user_accounts WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username, role FROM user_accounts WHERE username = ?")
                .passwordEncoder(bCryptPasswordEncoder());

        return authBuilder.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        BCryptPasswordEncoder bycriptpass = new BCryptPasswordEncoder();
        return bycriptpass;
    }

}



