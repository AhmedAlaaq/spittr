/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spittr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 *
 * @author Egelantier
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                 .authorizeRequests()
                 .antMatchers("/").authenticated()
                 .antMatchers("/spitter").authenticated()
                .antMatchers(HttpMethod.POST, "/spittles").authenticated()
                 .anyRequest().permitAll()
                 .and()
                 .requiresChannel()
                 .antMatchers("/spitter/register").requiresSecure()
                .and().formLogin()
                 .loginPage("/login")
                 .and()
                 .logout()
                 .logoutSuccessUrl("/")
                 .and()
                 .rememberMe()
                 .tokenValiditySeconds(2419200)
                 .key("spittrKey");           
                 
     }
    }


