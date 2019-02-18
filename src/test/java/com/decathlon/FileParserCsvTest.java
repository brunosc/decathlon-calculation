package com.decathlon;

import com.decathlon.model.AthletePerformance;
import com.decathlon.service.FileParser;
import com.decathlon.service.parser.FileParserCsv;
import com.decathlon.service.read.ReadTextFileCsv;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileParserCsvTest {

    @Test
    public void shouldParseCsvFromResourcesFolder() {

        FileParser fileParser = new FileParserCsv(new ReadTextFileCsv());

        List<AthletePerformance> athletePerformances = fileParser.parse(null);

        assertEquals(4, athletePerformances.size());
        assertEquals("John Smith", athletePerformances.get(0).getName());
        assertEquals("Foo Bar", athletePerformances.get(3).getName());

    }

}
