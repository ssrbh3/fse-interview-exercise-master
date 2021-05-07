package com.tradeledger.cards.eligibility.service;

import com.tradeledger.cards.eligibility.adapter.ThirdPartyEligibilityAdapter;
import com.tradeledger.cards.eligibility.dto.Applicant;
import com.tradeledger.cards.eligibility.dto.EligibilityResponse;
import com.tradeledger.cards.eligibility.model.QueueMessage;
import com.tradeledger.cards.eligibility.util.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willDoNothing;


@DisplayName("UT. CardEligibilityServiceImplTest.")
@ExtendWith(MockitoExtension.class)
class CardEligibilityServiceImplTest {

    @Mock
    private ThirdPartyEligibilityAdapter thirdPartyEligibilityAdapter;
    @Mock
    private QueueServiceImpl cardServiceImpl;
    @Mock
    private QueueMessageResponseService queueMessageResponseService;

    @InjectMocks
    private CardEligibilityServiceImpl target;

    @DisplayName("GIVEN applicant  WHEN eligibilityService THEN return eligibilityResponse ")
    @Test
    void testEligibilityService() {

        //given
        Applicant applicant = TestData.getApplicant();
        QueueMessage queueMessage = TestData.getQueueMessage();
        EligibilityResponse eligibilityResponse= TestData.getEligibilityResponse();
        given(thirdPartyEligibilityAdapter.getEligibility(any(Applicant.class))).willReturn(eligibilityResponse);
        given(queueMessageResponseService.createQueueResponse(any(),any())).willReturn(queueMessage);
        willDoNothing().given(cardServiceImpl).pushMessage(queueMessage);
        //when
        EligibilityResponse actualResponse = target.eligibilityService(applicant);

        //then
        assertEquals(eligibilityResponse.getEligibleCards(),actualResponse.getEligibleCards());
        then(thirdPartyEligibilityAdapter).should().getEligibility(any());

    }


}
