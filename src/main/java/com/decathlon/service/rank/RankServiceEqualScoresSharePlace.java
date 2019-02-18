package com.decathlon.service.rank;

import com.decathlon.model.AthletePerformance;
import com.decathlon.model.AthleteResult;
import com.decathlon.service.RankService;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankServiceEqualScoresSharePlace implements RankService {

    private Map<Integer, Integer> mapScoreOrder;

    @Override
    public List<AthleteResult> calculate(List<AthletePerformance> athletesPerformance) {
        mapScoreOrder = new HashMap<>();
        athletesPerformance.sort(Comparator.comparing(AthletePerformance::decathlon).reversed());
        return athletesPerformance.stream().map(this::mapResult).collect(Collectors.toList());
    }

    private AthleteResult mapResult(AthletePerformance athletePerformance) {

        int decathlon = athletePerformance.decathlon();

        if (! mapScoreOrder.containsKey(decathlon)) {
            mapScoreOrder.put(decathlon, mapScoreOrder.size() + 1);
        }

        return new AthleteResult(athletePerformance.getName(), decathlon, mapScoreOrder.get(decathlon));
    }

}
