package com.tradeledger.cards.eligibility.adapter;


import com.tradeledger.cards.eligibility.dto.Applicant;
import com.tradeledger.cards.eligibility.dto.EligibilityResponse;
import com.tradeledger.cards.eligibility.config.AppConfig;
import com.tradeledger.cards.eligibility.exception.EligibilityException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Adapter class for Third party apis
 */

@RequiredArgsConstructor
@Component
@Slf4j
public class ThirdPartyEligibilityAdapterImpl implements ThirdPartyEligibilityAdapter{


    private final AppConfig appConfig;
    private final RestTemplate restTemplate;

    /**
     * Rest call to Third party API here.
     * In case of exception user will be notified to try again later
     * and error will be logged for us to check Error and Applicant data.
     */
    @Override
    public EligibilityResponse getEligibility(Applicant applicant) {
        try {
            final UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(appConfig.getBaseUrl()).path("/eligibility").path("/check");
            final HttpEntity<Applicant> httpEntity = new HttpEntity<>(applicant);
            return restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.POST, httpEntity, EligibilityResponse.class).getBody();

        } catch (Exception e) {
            log.error("Error calling third party {} , Applicant data {} " , e, applicant);
            throw new EligibilityException("There was an issue connecting to third party APIs");
        }
    }
}
