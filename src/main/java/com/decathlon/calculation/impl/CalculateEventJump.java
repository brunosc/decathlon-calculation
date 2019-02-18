package com.decathlon.calculation.impl;

import com.decathlon.calculation.Decathlon;

public class CalculateEventJump extends CalculateEventField {

    private final static int CM_IN_METER = 100;

    @Override
    public int calculate(double athletePerformance, Decathlon decathlon) {
        return super.calculate(athletePerformance * CM_IN_METER, decathlon);
    }

}
