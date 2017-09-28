/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spittr.data;

import com.spittr.Spitter;

/**
 *
 * @author Egelantier
 */
public class SpitterRepository implements SpitterRepositoryInterface {

   
    @Override
    public Spitter save(Spitter spitter) {
        return spitter;
    }

    @Override
    public Spitter findByUsername(String username) {
        return new Spitter(1L, username, "ahmed-981", "Ahmed", "Talib");
    }
    
}
