package com.dsl.password.generator;

public class TestPasswordGenerator
{
    public static void main(String[] args)
    {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        System.out.println(passwordGenerator.generatePassword());;
    }
}
