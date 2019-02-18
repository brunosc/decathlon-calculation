package com.decathlon;

import com.decathlon.model.AthletePerformance;

import java.time.LocalTime;

public class DataLoader {

    private DataLoader(){}

    public static AthletePerformance with3099Decathlon() {
        return new AthletePerformance.Builder("Decathlon")
                .sprint100m(13.43)
                .longJump(4.35)
                .shotPut(8.64)
                .highJump(1.50)
                .sprint400m(66.06)
                .sprint110mHurdles(19.05)
                .discusThrow(24.89)
                .poleVault(2.20)
                .javelinThrow(33.48)
                .sprint1500mInSeconds(LocalTime.of(0, 6, 51).toSecondOfDay())
                .build();
    }

    public static AthletePerformance with4203Decathlon() {
        return new AthletePerformance.Builder("Decathlon")
                .sprint100m(12.61)
                .longJump(5.00)
                .shotPut(9.22)
                .highJump(1.50)
                .sprint400m(60.39)
                .sprint110mHurdles(16.43)
                .discusThrow(21.60)
                .poleVault(2.60)
                .javelinThrow(35.81)
                .sprint1500mInSeconds(LocalTime.of(0, 5, 25).toSecondOfDay())
                .build();
    }

    public static AthletePerformance with4374Decathlon() {
        return new AthletePerformance.Builder("Decathlon")
                .sprint100m(11.21)
                .longJump(5.25)
                .shotPut(8.99)
                .highJump(1.57)
                .sprint400m(59.39)
                .sprint110mHurdles(17.43)
                .discusThrow(22.68)
                .poleVault(2.67)
                .javelinThrow(34.99)
                .sprint1500mInSeconds(LocalTime.of(0, 5, 57).toSecondOfDay())
                .build();
    }
}
