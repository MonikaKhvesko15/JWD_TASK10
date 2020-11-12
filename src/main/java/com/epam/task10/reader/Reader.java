package com.epam.task10.reader;

import com.epam.task10.exception.DataException;

public interface Reader {
    String getData(String filename) throws DataException;
}
