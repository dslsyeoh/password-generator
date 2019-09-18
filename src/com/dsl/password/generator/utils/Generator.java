/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.password.generator.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Generator
{
    default String generatePassword()
    {
        return generatePassword(32);
    }

    String generatePassword(int length);

    default List<String> generateAlphabet()
    {
        return IntStream.range('a', 'z').mapToObj(value -> (char)value).map(String::valueOf).collect(Collectors.toList());
    }

    default List<String> generateNumbers()
    {
        return IntStream.rangeClosed(0, 9).mapToObj(String::valueOf).collect(Collectors.toList());
    }

    default List<String> getSymbols()
    {
        return Arrays.asList("[", "]", "@", "?", "<", ">", "$", "#", "!", "&", "%", "+", "-");
    }
}
