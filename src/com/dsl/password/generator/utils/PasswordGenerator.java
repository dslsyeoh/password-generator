/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.password.generator.utils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.dsl.password.generator.constants.Type.*;

public class PasswordGenerator implements Generator
{
    private Random random = new Random();

    private List<String> alphabets = generateAlphabets();
    private List<String> numeric = generateNumbers();
    private List<String> symbols = getSymbols();

    @Override
    public String generatePassword(int length)
    {
        return IntStream.range(0, length).map(value -> random.nextInt(3)).mapToObj(this::next).collect(Collectors.joining());
    }

    private String next(int type)
    {
        switch (type)
        {
            case ALPHABETIC:
                return format(alphabets.get(indexAt(alphabets.size())));
            case NUMERIC:
                return numeric.get(indexAt(numeric.size()));
            case SYMBOL:
                return symbols.get(indexAt(symbols.size()));
            default:
                return "";
        }
    }

    private int indexAt(int size)
    {
        return random.nextInt(size);
    }

    private String format(String value)
    {
        return random.nextInt(2) == 1 ? value.toUpperCase() : value;
    }
}
