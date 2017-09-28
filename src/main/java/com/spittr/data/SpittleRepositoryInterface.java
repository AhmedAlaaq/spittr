/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spittr.data;
import java.util.List;
import com.spittr.Spittle;

/**
 *
 * @author Egelantier
 */




public interface SpittleRepositoryInterface {
  List<Spittle> findSpittles(long max, int count);

    public Object findOne(long spittleId);

    public void save(Spittle spittle);
}