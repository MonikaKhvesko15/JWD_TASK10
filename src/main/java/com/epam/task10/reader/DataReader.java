package com.epam.task10.reader;

import com.epam.task10.exception.DataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DataReader implements Reader {
    public static final String DELIMITER = "\n";

    @Override
    public String getData(String filename) throws DataException {
        StringBuilder text = new StringBuilder();

        try {
            Path path = Paths.get(filename);
            Stream<String> streamFromFiles = Files.lines(path);
            streamFromFiles.forEach(s -> text.append(s).append(DELIMITER));
            return text.toString();
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
    }
}
