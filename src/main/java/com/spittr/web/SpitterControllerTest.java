/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spittr.web;

import com.spittr.Spitter;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.junit.Test;
import static org.mockito.Mockito.when;
import org.mockito.Mock;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import com.spittr.data.SpitterRepositoryInterface;

/**
 *
 * @author Egelantier
 */
public class SpitterControllerTest {

    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepositoryInterface mockRepository
                = mock(SpitterRepositoryInterface.class);	//#1: Set up mock repository
        Spitter unsaved
                = new Spitter("jbauer", "24hours", "Jack", "Bauer");
        Spitter saved
                = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
        when(mockRepository.save(unsaved)).thenReturn(saved);

        SpitterController controller
                = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();   //#2: Set up MockMvc	

        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("username", "jbauer") // #3: Perform request
                .param("password", "24hours"))
                .andExpect(redirectedUrl("/spitter/jbauer"));

        verify(mockRepository, atLeastOnce()).save(unsaved);	// #4: Verify save
    }

//#1: Set up MockMvc
//#2: Assert registerForm view
}
