package io.labs.anand.covidtracker.beans;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class Total {

    private BigInteger active;

    private BigInteger recovered;

    private BigInteger deaths;

    private BigInteger cases;

    private BigInteger todayActive;

    private BigInteger todayRecovered;

    private BigInteger todayDeaths;

    private BigInteger todayCases;

    public Total() {
    }

    public Total(BigInteger active, BigInteger recovered, BigInteger deaths, BigInteger cases, BigInteger todayActive, BigInteger todayRecovered, BigInteger todayDeaths, BigInteger todayCases) {
        this.active = active;
        this.recovered = recovered;
        this.deaths = deaths;
        this.cases = cases;
        this.todayActive = todayActive;
        this.todayRecovered = todayRecovered;
        this.todayDeaths = todayDeaths;
        this.todayCases = todayCases;
    }

}
