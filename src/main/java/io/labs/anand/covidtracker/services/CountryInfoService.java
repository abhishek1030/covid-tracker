package io.labs.anand.covidtracker.services;

import io.labs.anand.covidtracker.beans.Country;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

        BigInteger totalCasesSoFar = country.getStates().stream().map(cases -> cases.getCases()).reduce(BigInteger.ZERO, (a,b)->a.add(b));
        BigInteger totalRecoveredSoFar = country.getStates().stream().map(recovered -> recovered.getRecovered()).reduce(BigInteger.ZERO,(a,b)->a.add(b));

        return country;
    }
}
