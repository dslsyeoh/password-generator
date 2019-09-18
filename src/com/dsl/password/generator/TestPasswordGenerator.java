/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.password.generator;

import com.dsl.password.generator.utils.PasswordGenerator;

public class TestPasswordGenerator
{
    public static void main(String[] args)
    {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        for(int i = 0; i < 10; i++)
        {
            System.out.println(passwordGenerator.generatePassword());
        }
    }
}
