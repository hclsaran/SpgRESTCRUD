package com.saran;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saran.model.Product;
 
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestWebApp extends SpringBootRestcrudApplicationTests {
	@Autowired
	private  WebApplicationContext ctx;
	
	private MockMvc mvc;     
	    
	@BeforeEach
	public void setUp() {
		mvc=MockMvcBuilders.webAppContextSetup(ctx).build();		
	}
	
	@Test
	public void productTest() throws Exception{
		mvc.perform(get("/api/test/")).andExpect(status().isOk())
		.andExpect(jsonPath("$.prdName").value("Laptop"))
		.andExpect(jsonPath("$.prdPrice").value("123"));
		
	}


}
