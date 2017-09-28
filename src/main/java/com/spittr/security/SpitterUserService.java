/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spittr.security;

import com.spittr.Spitter;
import com.spittr.data.SpitterRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Egelantier
 */
public class SpitterUserService implements UserDetailsService {

    private final SpitterRepository spitterRepository;

    public SpitterUserService(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Spitter spitter = spitterRepository.findByUsername(username);
        if (spitter != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));

            return new User(
                    spitter.getUsername(),
                    spitter.getPassword(),
                    authorities);
        }
        throw new UsernameNotFoundException("User ' " + username + " ' not found.");
    }

}
