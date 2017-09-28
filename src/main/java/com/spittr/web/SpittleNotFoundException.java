/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spittr.web;

/**
 *
 * @author Egelantier
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,	  
                reason="Spittle Not Found")     //#1: Map exception to HTTP Status 404
public class SpittleNotFoundException extends RuntimeException {
}


