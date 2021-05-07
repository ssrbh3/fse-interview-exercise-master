package com.tradeledger.cards.eligibility.service;

import com.tradeledger.cards.eligibility.util.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Saurabh Sharma on 05/05/2021
 */
@DisplayName("UT. CardServiceImplTest.")
@ExtendWith(MockitoExtension.class)
class QueueServiceImplTest {

    @InjectMocks
    private QueueServiceImpl target;

    @DisplayName("GIVEN QueueMessage WHEN pushMessage THEN push message in queue")
    @Test
    void testPushMessage() {

        target.pushMessage(TestData.getQueueMessage());
    }

    @DisplayName("GIVEN QueueMessage WHEN pushMessage THEN push message in queue")
    @Test
    void testPushMessageFailure() {

        target.pushMessage(TestData.getQueueMessage());
    }

    @DisplayName("GIVEN failed messages in list WHEN retry THEN push message in queue")
    @Test
    void testRetry() {
        target.retry();
    }

}
