/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spittr.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 *
 * @author Egelantier
 */
@ControllerAdvice	                        //#1: Declare controller advice
public class AppWideExceptionHandler {

    @ExceptionHandler(DuplicateSpittleException.class)
    public String duplicateSpittleHandler() {    //#2: Define exceptionhandler method
        return "error/duplicate";
    }

}
