package com.decathlon.calculation.impl;

import com.decathlon.calculation.CalculateEvent;
import com.decathlon.calculation.Decathlon;

public class CalculateEventField implements CalculateEvent {

    public int calculate(double athletePerformance, Decathlon decathlon) {
        Double result = decathlon.getA() * Math.pow(athletePerformance - decathlon.getB(), decathlon.getC());
        return result.intValue();
    }

}
