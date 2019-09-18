/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.password.generator;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PasswordGenerator implements Generator
{
    private Random random = new Random();

    private List<String> alphabets = generateAlphabets();
    private List<String> numbers = generateNumbers();
    private List<String> symbols = getSymbols();

    @Override
    public String generatePassword()
    {
        return IntStream.range(0, 16).map(value -> random.nextInt(3)).mapToObj(this::next).collect(Collectors.joining());
    }

    private String next(int type)
    {
        switch (type)
        {
            case 0:
               return alphabets.get(indexAt(alphabets.size()));
            case 1:
                return numbers.get(indexAt(numbers.size()));
            case 2:
                return symbols.get(indexAt(symbols.size()));
            default:
                return "";
        }
    }

    private int indexAt(int size)
    {
        return random.nextInt(size);
    }
}
