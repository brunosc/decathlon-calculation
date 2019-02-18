package com.decathlon;

import com.decathlon.model.AthletePerformance;
import com.decathlon.model.AthleteResult;
import com.decathlon.service.RankService;
import com.decathlon.service.rank.RankServiceEqualScoresSharePlace;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RankServiceTest {

    @Test
    public void shouldHaveTwoFirstPlace() {

        List<AthletePerformance> athletePerformances = Arrays.asList(
                DataLoader.with3099Decathlon(),
                DataLoader.with4203Decathlon(),
                DataLoader.with4374Decathlon(),
                DataLoader.with4374Decathlon());

        RankService service = new RankServiceEqualScoresSharePlace();

        List<AthleteResult> athleteResults = service.calculate(athletePerformances);

        assertEquals(4, athleteResults.size());
        assertEquals(1, athleteResults.get(0).getRanking());
        assertEquals(1, athleteResults.get(1).getRanking());
        assertEquals(4374, athleteResults.get(0).getScore());
        assertEquals(4374, athleteResults.get(1).getScore());
    }

}
