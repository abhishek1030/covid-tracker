package io.labs.anand.covidtracker.controller;

import io.labs.anand.covidtracker.beans.Country;
import io.labs.anand.covidtracker.services.CountryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;
import java.net.ConnectException;


@Controller
@RequestMapping("/covid-tracker")
public class CovidController {

    @Autowired
    private CountryInfoService countryInfoService;


    @GetMapping("/india")
    public String getCountryInfo(Model model){
        try {
            Country countryInfo = countryInfoService.getCountryInfo();
            model.addAttribute("states",countryInfo.getStates());
            model.addAttribute("country",countryInfo);
        }
        catch (Exception exception){
            return "Facing issue while connecting to remote data source.";
        }
        return "home";
    }

    @GetMapping("/analytics")
    public String getCountryAnalytics(Model model){
        try {
            Country countryInfo = countryInfoService.getCountryInfo();
            model.addAttribute("activePercent", countryInfo.getTotal().getActive());
            model.addAttribute("recoveredPercent", countryInfo.getTotal().getRecovered());
            model.addAttribute("deathsPercent", countryInfo.getTotal().getDeaths());
            model.addAttribute("sortedStatesList", countryInfo.getSortedStates());
        }
        catch (Exception exception){
            return "Facing issue while connecting to remote data source.";
        }
        return "covidAnalytics";
    }

}
