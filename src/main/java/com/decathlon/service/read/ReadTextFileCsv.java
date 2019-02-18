package com.decathlon.service.read;

import com.decathlon.exception.ReadTextFileException;
import com.decathlon.service.ReadTextFile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadTextFileCsv implements ReadTextFile {

    @Override
    public List<String> read(String filePath) {
        try (Stream<String> stream = stream(Optional.ofNullable(filePath).orElse(""))) {
            return stream
                    .filter(this::nonBlank)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ReadTextFileException(e.getMessage());
        }
    }

    private Stream<String> stream(String filePath) throws IOException, URISyntaxException {
        if (exists(filePath)) {
            return Files.lines(Paths.get(filePath));
        }

        return Files.lines(Paths.get(getClass().getResource("/results.csv").toURI()));
    }

    private boolean exists(String filePath) {
        Path path = Paths.get(filePath);
        return Files.exists(path) && !Files.isDirectory(path);
    }

    private boolean nonBlank(String line) {
        return line != null && ! line.isEmpty();
    }

}
