package com.decathlon.calculation.impl;

import com.decathlon.calculation.CalculateEvent;
import com.decathlon.calculation.Decathlon;

public class CalculateEventTrack implements CalculateEvent {

    public int calculate(double athletePerformance, Decathlon decathlon) {
        Double result = decathlon.getA() * Math.pow(decathlon.getB() - athletePerformance, decathlon.getC());
        return result.intValue();
    }

}
