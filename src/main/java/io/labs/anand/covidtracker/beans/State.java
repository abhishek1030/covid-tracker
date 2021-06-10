package io.labs.anand.covidtracker.beans;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class State {

    private String state;

    private BigInteger active;

    private BigInteger recovered;

    private BigInteger deaths;

    private BigInteger cases;

    private BigInteger todayActive;

    private BigInteger todayRecovered;

    private BigInteger todayDeaths;

    private BigInteger todayCases;

    private float recoveryRate;

    public State() {
    }

    public State(String state, BigInteger active, BigInteger recovered, BigInteger deaths, BigInteger cases, BigInteger todayActive, BigInteger todayRecovered, BigInteger todayDeaths, BigInteger todayCases) {
        this.state = state;
        this.active = active;
        this.recovered = recovered;
        this.deaths = deaths;
        this.cases = cases;
        this.todayActive = todayActive;
        this.todayRecovered = todayRecovered;
        this.todayDeaths = todayDeaths;
        this.todayCases = todayCases;
    }

    @Override
    public String toString() {
        return "State{" +
                "state:'" + state +" , "+
                "recoveryRate:'" + recoveryRate +
                '}';
    }
}
