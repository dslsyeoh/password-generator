package com.dsl.password.generator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Generator
{
    String generatePassword();

    default List<String> generateAlphabets()
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
