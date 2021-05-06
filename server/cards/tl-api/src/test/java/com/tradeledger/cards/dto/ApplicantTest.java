package com.tradeledger.cards.dto;

import com.tradeledger.cards.util.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Saurabh Sharma on 03/05/2021
 */
@DisplayName("UT. ApplicantTest.")
@ExtendWith(MockitoExtension.class)
class ApplicantTest {

    @Test
    void test() {

        //given
        Applicant applicant = TestData.getApplicant();

        assertEquals("Boris",applicant.getName());
        assertEquals("Boris@bbc.com",applicant.getEmail());
        assertEquals("12 Whitechapel Road",applicant.getAddress());
    }


}
