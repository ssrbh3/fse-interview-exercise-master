package com.tradeledger.cards.eligibility.service;

import com.tradeledger.cards.eligibility.model.QueueMessage;
import com.tradeledger.cards.eligibility.util.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Saurabh Sharma on 05/05/2021
 */
@DisplayName("UT. QueueMessageResponseServiceServiceImplTest.")
@ExtendWith(MockitoExtension.class)
class QueueMessageResponseServiceServiceImplTest {

    @InjectMocks
    private QueueMessageResponseServiceServiceImpl target;

    @DisplayName("GIVEN Applicant, EligibilityResponse WHEN createQueueResponse THEN return QueueMessage ")
    @Test
    void testCreateQueueResponse() {

        QueueMessage expected = TestData.getQueueMessage();
        QueueMessage actual = target.createQueueResponse(TestData.getApplicant(), TestData.getEligibilityResponse());

        Assertions.assertEquals(expected.getApplicant().getName(), actual.getApplicant().getName());
        Assertions.assertEquals(expected.getEligibilityResponse().getEligibleCards(), actual.getEligibilityResponse().getEligibleCards());

    }


}
