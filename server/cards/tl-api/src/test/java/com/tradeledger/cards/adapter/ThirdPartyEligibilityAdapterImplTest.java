package com.tradeledger.cards.adapter;

import com.tradeledger.cards.dto.EligibilityResponse;
import com.tradeledger.cards.config.AppConfig;
import com.tradeledger.cards.exception.EligibilityException;
import com.tradeledger.cards.util.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@DisplayName("UT. ThirdPartyEligibilityAdapterImplTest.")
@ExtendWith(MockitoExtension.class)
class ThirdPartyEligibilityAdapterImplTest {

    @Mock
    private AppConfig appConfig;
    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private ThirdPartyEligibilityAdapterImpl target;

    @DisplayName("GIVEN applicant details  WHEN getEligibility THEN return EligibilityResponse ")
    @Test
    void testGetEligibility() {

        //given
        EligibilityResponse expectedEligibilityResponse = TestData.getEligibilityResponse();
        ResponseEntity<EligibilityResponse> responseEntity = ResponseEntity.of(Optional.of(expectedEligibilityResponse));
        given(appConfig.getBaseUrl()).willReturn("https://dev.thirdparty/api");
        given(restTemplate.exchange(anyString(), any(), any(HttpEntity.class), eq(EligibilityResponse.class))).willReturn(responseEntity);

        //when
        EligibilityResponse actualEligibilityResponse = target.getEligibility(TestData.getApplicant());

        //then
        assertEquals(expectedEligibilityResponse.getEligibleCards().size(),
                actualEligibilityResponse.getEligibleCards().size());
        assertEquals(expectedEligibilityResponse.getEligibleCards(), actualEligibilityResponse.getEligibleCards());
        then(restTemplate).should().exchange(anyString(), any(), any(HttpEntity.class), eq(EligibilityResponse.class));

    }

    @DisplayName("GIVEN applicant and third party api is down details  WHEN getEligibility THEN exception ")
    @Test
    void testGetEligibilityFailure() {

        //given

        given(appConfig.getBaseUrl()).willReturn("https://dev.thirdparty/api");
        given(restTemplate.exchange(anyString(), any(), any(HttpEntity.class), eq(EligibilityResponse.class))).willThrow(new EligibilityException("There was an issue connecting to third party APIs"));

        //when
        assertThrows(EligibilityException.class, ()->{
            target.getEligibility(TestData.getApplicant());
        });


    }


}
