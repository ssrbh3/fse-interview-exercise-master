package com.tradeledger.cards.controller;

import com.tradeledger.cards.dto.EligibilityResponse;
import com.tradeledger.cards.service.CardEligibilityService;
import com.tradeledger.cards.util.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("UT. CardControllerTest.")
@WebMvcTest(CardEligibilityController.class)
class CardEligibilityControllerTest {

    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CardEligibilityService cardEligibilityService;

    @DisplayName("GIVEN applicant WHEN checkEligibility THEN return EligibilityResponse and status 200")
    @Test
    void testCheckEligibility_200() throws Exception {

        //given
        EligibilityResponse eligibilityResponse = TestData.getEligibilityResponse();
        given(cardEligibilityService.eligibilityService(TestData.getApplicant())).willReturn(eligibilityResponse);
        Path path = Paths.get("src","test","resources","inputBody.json");
        String content = Files.readString(path);

        //when
        mvc.perform(post("/check-eligibility").contentType(APPLICATION_JSON)
                .content(content))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());

        //then
        then(cardEligibilityService).should().eligibilityService(any());

    }

    @DisplayName("GIVEN no Body WHEN checkEligibility THEN status 400 ")
    @Test
    void testCheckEligibility_400() throws Exception {

        //when
        mvc.perform(post("/check-eligibility").contentType(APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }
}
