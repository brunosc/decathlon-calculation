package com.decathlon.util;

import com.decathlon.exception.ReadTextFileException;

import java.time.LocalTime;

public class StringConverterUtils {

    private StringConverterUtils(){}

    public static Double toDouble(String value) {
        try {
            return Double.valueOf(value);
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer timeToSeconds(String value) {
        try {
            String[] split = value.trim().split("\\.");
            LocalTime test = LocalTime.of(0, Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            return test.toSecondOfDay();
        } catch (Exception e) {
            throw new ReadTextFileException(String.format("Error on convert %s to seconds. Error: %s", value, e.getMessage()));
        }
    }

}
