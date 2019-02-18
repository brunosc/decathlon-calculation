package com.decathlon.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private final static String INFO = " [INFO] - ";
    private final static String ERROR = " [ERROR] - ";
    private final static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Logger(){}

    public static void info(String message, Object... params) {
        System.out.println(
                String.format(instant().concat(INFO).concat(message), params)
        );
    }

    public static void error(String message, Object... params) {
        System.out.println(
                String.format(instant().concat(ERROR).concat(message), params)
        );
    }

    private static String instant() {
        return LocalDateTime.now().format(dateFormatter);
    }

}
