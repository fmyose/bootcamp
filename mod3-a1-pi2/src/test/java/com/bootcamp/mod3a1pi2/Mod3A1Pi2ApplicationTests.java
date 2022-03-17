package com.bootcamp.mod3a1pi2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
class Mod3A1Pi2ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testOneWordWithSingleSpace() throws Exception {
		mockMvc.perform(get("/convert")
				.queryParam("morse", "... .--. .-. .. -. --."))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("SPRING")));
	}

	@Test
	void testOneWordWithTwoSpace() throws Exception {
		mockMvc.perform(get("/convert")
				.queryParam("morse", "...  .--. .-.  .. -.  --."))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("SPRING")));
	}

	@Test
	void testTwoWordPhrase() throws Exception {
		mockMvc.perform(get("/convert")
				.queryParam("morse", "...  .--. .-. .. -. --.   -... --- ---  -"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("SPRING BOOT")));
	}

	@Test
	void testTwoWordPhraseWithManySpaces() throws Exception {
		mockMvc.perform(get("/convert")
				.queryParam("morse", "...  .--. .-. .. -. --.     -... --- ---  -"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("SPRING BOOT")));
	}

	@Test
	void testEmptyPhrase() throws Exception {
		mockMvc.perform(get("/convert")
				.queryParam("morse", ""))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("")));
	}

	@Test
	void testInvalidMorseCode() throws Exception {
		mockMvc.perform(get("/convert")
				.queryParam("morse", "--.-.-.-...-"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("**")));
	}

	@Test
	void testInvalidAndValidMorseCode() throws Exception {
		mockMvc.perform(get("/convert")
				.queryParam("morse", "--.-.-.-...- .- .-"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("**AA")));
	}
}
