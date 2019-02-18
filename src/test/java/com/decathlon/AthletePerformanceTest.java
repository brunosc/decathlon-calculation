package com.decathlon;

import com.decathlon.model.AthletePerformance;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class AthletePerformanceTest {

    @Test
    public void shouldCalculateDecathlon() {
        AthletePerformance athletePerformance = DataLoader.with3099Decathlon();
        assertEquals(3099, athletePerformance.decathlon());
    }

    @Test
    public void shouldCalculateWithoutValues() {
        AthletePerformance noValues = new AthletePerformance.Builder("NoValues").build();
        assertEquals(0, noValues.decathlon());
    }

    @Test
    public void shouldCalculateSprint100m() {
        AthletePerformance sprint100m = new AthletePerformance.Builder("Sprint100m").sprint100m(13.04).build();
        assertEquals(461, sprint100m.calculate100m());
    }

    @Test
    public void shouldCalculateLongJump() {
        AthletePerformance longJump = new AthletePerformance.Builder("LongJump").longJump(5.00).build();
        assertEquals(382, longJump.calculateLongJump());
    }

    @Test
    public void shouldCalculateShotPut() {
        AthletePerformance shotPut = new AthletePerformance.Builder("ShotPut").shotPut(9.22).build();
        assertEquals(439, shotPut.calculateShotPut());
    }

    @Test
    public void shouldCalculateHighJump() {
        AthletePerformance highJump = new AthletePerformance.Builder("HighJump").highJump(1.50).build();
        assertEquals(389, highJump.calculateHighJump());
    }

    @Test
    public void shouldCalculate400m() {
        AthletePerformance sprint400m = new AthletePerformance.Builder("Sprint400m").sprint400m(60.39).build();
        assertEquals(400, sprint400m.calculate400m());
    }

    @Test
    public void shouldCalculate110mHurdles() {
        AthletePerformance sprint110mHurdles = new AthletePerformance.Builder("Sprint110mHurdles").sprint110mHurdles(16.43).build();
        assertEquals(685, sprint110mHurdles.calculate110mHurdles());
    }

    @Test
    public void shouldCalculateDiscusThrow() {
        AthletePerformance discusThrow = new AthletePerformance.Builder("DiscusThrow").discusThrow(21.60).build();
        assertEquals(302, discusThrow.calculateDiscusThrow());
    }

    @Test
    public void shouldCalculatePoleVault() {
        AthletePerformance poleVault = new AthletePerformance.Builder("PoleVault").poleVault(2.60).build();
        assertEquals(264, poleVault.calculatePoleVault());
    }

    @Test
    public void shouldCalculateJavelinThrow() {
        AthletePerformance javelinThrow = new AthletePerformance.Builder("JavelinThrow").javelinThrow(35.81).build();
        assertEquals(382, javelinThrow.calculateJavelinThrow());
    }

    @Test
    public void shouldCalculateSprint1500m() {

        AthletePerformance javelinThrow = new AthletePerformance.Builder("JavelinThrow").sprint1500mInSeconds(LocalTime.of(0, 5, 25).toSecondOfDay()).build();
        assertEquals(424, javelinThrow.calculate1500m());
    }

}
