/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.password.generator.utils;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.dsl.password.generator.constants.Type.*;

public class PasswordGenerator implements Generator
{
    private static final int LIMIT_IN_A_ROW = 3;

    private Random random = new Random();

    private List<String> alphabet = generateAlphabet();
    private List<String> numeric = generateNumbers();
    private List<String> symbols = getSymbols();

    private int alphabetCount = 0;
    private int numericCount = 0;
    private int symbolCount = 0;

    @Override
    public String generatePassword(int length)
    {
        return IntStream.range(0, length).map(value -> random.nextInt(3)).mapToObj(this::next).collect(Collectors.joining());
    }

    private String next(int type)
    {
        switch (validType(type))
        {
            case ALPHABET:
                alphabetCount++;
                numericCount = 0;
                symbolCount = 0;
                return format(alphabet.get(indexAt(alphabet.size())));
            case NUMERIC:
                alphabetCount =0;
                numericCount++;
                symbolCount=0;
                return numeric.get(indexAt(numeric.size()));
            case SYMBOL:
                alphabetCount =0;
                numericCount=0;
                symbolCount++;
                return symbols.get(indexAt(symbols.size()));
            default:
                return "";
        }
    }

    private int validType(int type)
    {
        Integer exceedLimitType = getExceedLimitType();
        if(Objects.nonNull(exceedLimitType))
        {
            int newType = random.nextInt(3);
            while(newType == exceedLimitType)
            {
                newType = random.nextInt(3);
            }
            return newType;
        }
        return type;
    }

    private Integer getExceedLimitType()
    {
        if(alphabetCount == LIMIT_IN_A_ROW) return ALPHABET;
        if(numericCount == LIMIT_IN_A_ROW) return NUMERIC;
        if(symbolCount == LIMIT_IN_A_ROW) return SYMBOL;
        return null;
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
