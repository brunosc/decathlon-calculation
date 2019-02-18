package com.decathlon;

import com.decathlon.service.ReadTextFile;
import com.decathlon.service.read.ReadTextFileCsv;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReadTextFileCsvTest {

    @Test
    public void shoulReadResultsCsvOnResourcesFolder() {

        ReadTextFile readTextFile = new ReadTextFileCsv();

        List<String> lines = readTextFile.read(null);

        assertEquals(4, lines.size());
        assertEquals("John Smith;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72", lines.get(0).trim());
        assertEquals("Foo Bar;13.43;4.35;8.64;1.50;66.06;19.05;24.89;2.20;33.48;6.51.01", lines.get(3).trim());

    }

}
