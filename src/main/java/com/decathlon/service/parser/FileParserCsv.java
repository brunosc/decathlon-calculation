package com.decathlon.service.parser;

import com.decathlon.model.AthletePerformance;
import com.decathlon.service.FileParser;
import com.decathlon.service.ReadTextFile;

import java.util.List;
import java.util.stream.Collectors;

import static com.decathlon.util.CsvValueConstants.INDEX_100_M;
import static com.decathlon.util.CsvValueConstants.INDEX_100_M_HURDLES;
import static com.decathlon.util.CsvValueConstants.INDEX_1500_M;
import static com.decathlon.util.CsvValueConstants.INDEX_400_M;
import static com.decathlon.util.CsvValueConstants.INDEX_DISCUS_THROW;
import static com.decathlon.util.CsvValueConstants.INDEX_HIGH_JUMP;
import static com.decathlon.util.CsvValueConstants.INDEX_JAVELIN_THROW;
import static com.decathlon.util.CsvValueConstants.INDEX_LONG_JUMP;
import static com.decathlon.util.CsvValueConstants.INDEX_NAME;
import static com.decathlon.util.CsvValueConstants.INDEX_POLE_VAULT;
import static com.decathlon.util.CsvValueConstants.INDEX_SHOT_PUT;
import static com.decathlon.util.StringConverterUtils.timeToSeconds;
import static com.decathlon.util.StringConverterUtils.toDouble;

public class FileParserCsv implements FileParser {

    private ReadTextFile readTextFile;

    public FileParserCsv(ReadTextFile readTextFile) {
        this.readTextFile = readTextFile;
    }

    @Override
    public List<AthletePerformance> parse(String filePath) {
        List<String> lines = readTextFile.read(filePath);
        return lines.stream().map(this::map).collect(Collectors.toList());
    }

    private AthletePerformance map(String line) {

        String[] values = line.split(";");

        return new AthletePerformance.Builder(values[INDEX_NAME])
                        .sprint100m(toDouble(values[INDEX_100_M]))
                        .longJump(toDouble(values[INDEX_LONG_JUMP]))
                        .shotPut(toDouble(values[INDEX_SHOT_PUT]))
                        .highJump(toDouble(values[INDEX_HIGH_JUMP]))
                        .sprint400m(toDouble(values[INDEX_400_M]))
                        .sprint110mHurdles(toDouble(values[INDEX_100_M_HURDLES]))
                        .discusThrow(toDouble(values[INDEX_DISCUS_THROW]))
                        .poleVault(toDouble(values[INDEX_POLE_VAULT]))
                        .javelinThrow(toDouble(values[INDEX_JAVELIN_THROW]))
                        .sprint1500mInSeconds(timeToSeconds(values[INDEX_1500_M]))
                    .build();
    }

}
