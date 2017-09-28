/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spittr.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import com.spittr.web.HomeController;

/**
 *
 * @author Egelantier
 */
public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc
                = standaloneSetup(controller).build();

        mockMvc.perform(get("/"))
                .andExpect(view().name("home"));
    }
}

//#1: Set up MockMvc
//#2: Perform GET /
//#3: Expect home view
