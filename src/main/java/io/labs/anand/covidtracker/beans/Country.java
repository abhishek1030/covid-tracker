package io.labs.anand.covidtracker.beans;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
public class Country {

    private BigInteger updated;

    private Total total;

    private List<State> states;

    private List<State> sortedStates;

    public Country() {
    }

    public Country(BigInteger updated, Total total, List<State> states) {
        this.updated = updated;
        this.total = total;
        this.states = states;
    }
}
