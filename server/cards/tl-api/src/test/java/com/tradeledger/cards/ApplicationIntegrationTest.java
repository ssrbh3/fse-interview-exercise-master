package com.tradeledger.cards;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@Disabled("Disabling to avoid test failure in case of third party is down, Please ensure third party is running to execute this test")
@DisplayName("IT. ApplicationTest")
@SpringBootTest
@AutoConfigureMockMvc
class ApplicationIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @DisplayName("Integration Test for Application")
    @Test
    void test() throws Exception {

        //given
        Path path = Paths.get("src","test","resources","inputBody.json");
        String content = Files.readString(path);

        // when // then
        mvc.perform(post("/check-eligibility")
                .contentType(APPLICATION_JSON)
                .content(content))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("eligibleCards").isArray())
                .andExpect(jsonPath("eligibleCards[0]", Matchers.is("C1")))
                .andExpect(status().is2xxSuccessful());
    }

}
