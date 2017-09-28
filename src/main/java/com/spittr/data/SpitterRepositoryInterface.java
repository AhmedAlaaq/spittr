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
public interface SpitterRepositoryInterface {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
