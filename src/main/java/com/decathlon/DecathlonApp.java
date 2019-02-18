package com.decathlon;

import com.decathlon.exception.ParameterValidationException;
import com.decathlon.model.AthletePerformance;
import com.decathlon.model.AthleteResult;
import com.decathlon.service.FileParser;
import com.decathlon.service.GenerateFile;
import com.decathlon.service.RankService;
import com.decathlon.service.generate.GenerateFileXml;
import com.decathlon.service.parser.FileParserCsv;
import com.decathlon.service.rank.RankServiceEqualScoresSharePlace;
import com.decathlon.service.read.ReadTextFileCsv;
import com.decathlon.util.Logger;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class DecathlonApp {

    private final Clock clock = Clock.systemDefaultZone();

    private FileParser fileParser;
    private RankService rankService;
    private GenerateFile generateFile;

    private DecathlonApp() {
        fileParser = new FileParserCsv(new ReadTextFileCsv());
        rankService = new RankServiceEqualScoresSharePlace();
        generateFile = new GenerateFileXml();
    }

    public static void main(String[] args) {
        DecathlonApp app = new DecathlonApp();
        app.execute(app.getFilePath(args));
    }

    private void execute(String filePath) {
        Instant start = clock.instant();
        List<AthletePerformance> athletes = fileParser.parse(filePath);
        List<AthleteResult> results = rankService.calculate(athletes);
        generateFile.generate(results);
        Logger.info("> Execution time: %s in ms", Duration.between(start, clock.instant()).toMillis());
    }

    private String getFilePath(String[] args) {
        if (args.length > 0) {
            return args[0];
        }
        throw new ParameterValidationException("It is necessary one parameter (file path) at least");
    }

}
