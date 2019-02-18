package com.decathlon.service;

import com.decathlon.model.AthletePerformance;
import com.decathlon.model.AthleteResult;

import java.util.List;

public interface RankService {

    List<AthleteResult> calculate(List<AthletePerformance> athletesPerformance);

}
