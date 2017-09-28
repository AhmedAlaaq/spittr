/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spittr.data;

import com.spittr.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Egelantier
 */
public class SpittleRepository implements SpittleRepositoryInterface {

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Finding Spittle" + i, new Date()));
        }
        return spittles;
    }

    @Override
    public Spittle findOne(long spittleId) {
        return new Spittle("Finding Spittle", new Date());
    }

    @Override
    public void save(Spittle spittle){

    }
}
