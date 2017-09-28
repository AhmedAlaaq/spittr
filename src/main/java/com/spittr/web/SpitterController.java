/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.spittr.Spitter;
import javax.validation.Valid;
import org.springframework.validation.Errors;
import com.spittr.data.SpitterRepositoryInterface;
import java.io.IOException;
import javax.servlet.http.Part;
import org.springframework.web.bind.annotation.RequestPart;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepositoryInterface spitterRepository;

    @Autowired
    public SpitterController(
            SpitterRepositoryInterface spitterRepository) {    //#1: Inject SpitterRepositoryInterface
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(@RequestPart("profilePicture") Part profilePicture,
            @Valid Spitter spitter, Errors errors) throws IOException {      //: Save a Spitter &   //: Validate Spitter input

        if (errors.hasErrors()) {
            return "registerForm";
        }

        spitterRepository.save(spitter);
        profilePicture.write("/data/spittr/"
                + profilePicture.getSubmittedFileName());
        return "redirect:/spitter/"
                + spitter.getUsername();   //#3: Redirect to profile page
    }

    @RequestMapping(value = "/{username}", method = GET)
    public String showSpitterProfile(
            @PathVariable String username, Model model) {
        if (!model.containsAttribute("spitter")) {
            model.addAttribute(
                    spitterRepository.findByUsername(username));
        }
        return "profile";
    }
}
