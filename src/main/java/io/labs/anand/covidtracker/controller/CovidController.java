package io.labs.anand.covidtracker.controller;

import io.labs.anand.covidtracker.beans.Country;
import io.labs.anand.covidtracker.services.CountryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/covid-tracker")
public class CovidController {

    @Autowired
    private CountryInfoService countryInfoService;


    @GetMapping("/india")
    public String getCountryInfo(Model model){
        Country countryInfo = countryInfoService.getCountryInfo();
        model.addAttribute("states",countryInfo.getStates());
        model.addAttribute("country",countryInfo);

        return "home";
    }

    @GetMapping("/india/analytics")
    public String getCountryAnalytics(Model model){

        return "covidAnalytics";
    }

}
