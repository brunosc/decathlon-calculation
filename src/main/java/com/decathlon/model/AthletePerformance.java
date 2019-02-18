package com.decathlon.model;

import com.decathlon.calculation.Decathlon;

import java.util.Optional;

public class AthletePerformance {

    private int decathlon = -1;
    private String name;

    private Double sprint100m;
    private Double longJump;
    private Double shotPut;
    private Double highJump;
    private Double sprint400m;
    private Double sprint100mHurdles;
    private Double discusThrow;
    private Double poleVault;
    private Double javelinThrow;
    private Integer sprint1500mInSeconds;

    public int decathlon() {
        if (decathlon == -1) {
            decathlon = calculateDecathlon();
        }
        return decathlon;
    }

    private int calculateDecathlon() {
        return calculate100m() +
                calculateLongJump() +
                calculateShotPut() +
                calculateHighJump() +
                calculate400m() +
                calculate110mHurdles() +
                calculateDiscusThrow() +
                calculatePoleVault() +
                calculateJavelinThrow() +
                calculate1500m();
    }

    public String getName() {
        return name;
    }

    public int calculate100m() {
        return Optional.ofNullable(sprint100m).map(Decathlon.SPRINT_100M::calculate).orElse(0);
    }

    public int calculateLongJump() {
        return Optional.ofNullable(longJump).map(Decathlon.LONG_JUMP::calculate).orElse(0);
    }

    public int calculateShotPut() {
        return Optional.ofNullable(shotPut).map(Decathlon.SHOT_PUT::calculate).orElse(0);
    }

    public int calculateHighJump() {
        return Optional.ofNullable(highJump).map(Decathlon.HIGH_JUMP::calculate).orElse(0);
    }

    public int calculate400m() {
        return Optional.ofNullable(sprint400m).map(Decathlon.SPRINT_400M::calculate).orElse(0);
    }

    public int calculate110mHurdles() {
        return Optional.ofNullable(sprint100mHurdles).map(Decathlon.SPRINT_100M_HURDLES::calculate).orElse(0);
    }

    public int calculateDiscusThrow() {
        return Optional.ofNullable(discusThrow).map(Decathlon.DISCUS_THROW::calculate).orElse(0);
    }

    public int calculatePoleVault() {
        return Optional.ofNullable(poleVault).map(Decathlon.POLE_VAULT::calculate).orElse(0);
    }

    public int calculateJavelinThrow() {
        return Optional.ofNullable(javelinThrow).map(Decathlon.JAVELIN_THROW::calculate).orElse(0);
    }

    public int calculate1500m() {
        return Optional.ofNullable(sprint1500mInSeconds).map(Decathlon.SPRINT_1500M::calculate).orElse(0);
    }

    public static class Builder {

        private final String name;

        private Double sprint100m = null;
        private Double longJump = null;
        private Double shotPut = null;
        private Double highJump = null;
        private Double sprint400m = null;
        private Double sprint110mHurdles = null;
        private Double discusThrow = null;
        private Double poleVault = null;
        private Double javelinThrow = null;
        private Integer sprint1500mInSeconds = null;

        public Builder(String name) {
            this.name = name;
        }

        public Builder sprint100m(Double sprint100m) {
            this.sprint100m = sprint100m;
            return this;
        }

        public Builder longJump(Double longJump) {
            this.longJump = longJump;
            return this;
        }

        public Builder shotPut(Double shotPut) {
            this.shotPut = shotPut;
            return this;
        }

        public Builder highJump(Double highJump) {
            this.highJump = highJump;
            return this;
        }

        public Builder sprint400m(Double sprint400m) {
            this.sprint400m = sprint400m;
            return this;
        }

        public Builder sprint110mHurdles(Double sprint110mHurdles) {
            this.sprint110mHurdles = sprint110mHurdles;
            return this;
        }

        public Builder discusThrow(Double discusThrow) {
            this.discusThrow = discusThrow;
            return this;
        }

        public Builder poleVault(Double poleVault) {
            this.poleVault = poleVault;
            return this;
        }

        public Builder javelinThrow(Double javelinThrow) {
            this.javelinThrow = javelinThrow;
            return this;
        }

        public Builder sprint1500mInSeconds(Integer sprint1500mInSeconds) {
            this.sprint1500mInSeconds = sprint1500mInSeconds;
            return this;
        }

        public AthletePerformance build() {
            return new AthletePerformance(this);
        }
    }

    private AthletePerformance(Builder builder) {
        name = builder.name;
        sprint100m = builder.sprint100m;
        longJump = builder.longJump;
        shotPut = builder.shotPut;
        highJump = builder.highJump;
        sprint400m = builder.sprint400m;
        sprint100mHurdles = builder.sprint110mHurdles;
        discusThrow = builder.discusThrow;
        poleVault = builder.poleVault;
        javelinThrow = builder.javelinThrow;
        sprint1500mInSeconds = builder.sprint1500mInSeconds;
    }
}
