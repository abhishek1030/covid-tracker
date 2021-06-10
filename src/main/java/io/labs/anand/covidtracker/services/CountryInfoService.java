package io.labs.anand.covidtracker.services;

import io.labs.anand.covidtracker.beans.Country;
import io.labs.anand.covidtracker.beans.State;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CountryInfoService {

    RestTemplate restTemplate = new RestTemplate();

    @Value("${user-agent}")
    private String userAgent;

    @Value("${baseURL.country-info}")
    private String countryInfoBaseURL;

    @Value("${country.name}")
    private String countryName;

    @Scheduled(cron = "3 * * * * *")
    public Country getCountryInfo(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("user-agent", userAgent);
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);

        ResponseEntity<Country> responseEntity = restTemplate.exchange(countryInfoBaseURL+countryName, HttpMethod.GET,requestEntity,Country.class);
        Country country = responseEntity.getBody();

        //Sorting starts here
        List<State> sortedStateList = new ArrayList<State>();
        for(State state:country.getStates()){
            float recoveryRate = (state.getRecovered().floatValue()/state.getCases().floatValue())*100;
            state.setRecoveryRate(recoveryRate);
            sortedStateList.add(state);
        }
        Collections.sort(sortedStateList, new Comparator<State>() {
            @Override
            public int compare(State state1, State state2) {
                return Float.compare(state1.getRecoveryRate(),state2.getRecoveryRate());
            }
        });
        country.setSortedStates(sortedStateList);
        //sorting ends here

        return country;
    }
}
