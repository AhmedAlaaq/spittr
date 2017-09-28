/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spittr.web;

import com.spittr.Spittle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static java.lang.Long.MAX_VALUE;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.spittr.data.SpittleRepositoryInterface;
import java.util.Date;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Egelantier
 */
@Controller
@RequestMapping("/spittles") //HTTP path
public class SpittleController {

    private SpittleRepositoryInterface spittleRepository;
    private static final String MAX_LONG_AS_STRING
            = Long.toString(Long.MAX_VALUE);

    @Autowired
    public SpittleController(
            SpittleRepositoryInterface spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            // @RequestParam(value="max",defaultValue=MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "max", defaultValue = "60") long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showSpittle(
            @RequestParam("spittle_id") long spittleId,
            Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

    /*@RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            @PathVariable long spittleId,
            Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }*/
    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            @PathVariable("spittleId") long spittleId,
            Model model) {
        Spittle spittle = (Spittle) spittleRepository.findOne(spittleId);
        if (spittle == null) {
            throw new SpittleNotFoundException();
        }
        model.addAttribute(spittle);
        return "spittle";
    }
    
    @RequestMapping(method=RequestMethod.POST)
public String saveSpittle(Spittle form, Model model) {
  spittleRepository.save(
      new Spittle(form.getMessage(), new Date(),
          form.getLongitude(), form.getLatitude()));
  return "redirect:/spittles";
}


}

//#1: Inject SpittleRepositoryInterface
//#2: Add spittles to model
//#3: Return view name
