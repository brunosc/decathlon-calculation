package com.decathlon.service;

import com.decathlon.model.AthletePerformance;

import java.util.List;

public interface FileParser {

    List<AthletePerformance> parse(String filePath);

}
