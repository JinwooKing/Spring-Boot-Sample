package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class DemoApplicationTests {

	@Autowired
	MockMvc mvc;

	@Test
	void CheckHealth() throws Exception {
		this.mvc.perform(get("/health"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello World!")));
	}

	@Test
	void CheckHealth2() throws Exception {
		this.mvc.perform(get("/health2"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello World!")));
	}
}
