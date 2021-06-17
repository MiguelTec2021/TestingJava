package com.uttl.javatest.Fizzbuzz;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class FizzBuzzShould {

    @Test
    public void number_is_divisible_by_3_is_Fizz() {

        Assert.assertEquals("Fizz", jFizzBuzz.fizzBuzz(3));
        Assert.assertEquals("Fizz", jFizzBuzz.fizzBuzz(6));
        Assert.assertEquals("Buzz", jFizzBuzz.fizzBuzz(5));
        Assert.assertEquals("Buzz", jFizzBuzz.fizzBuzz(10));
        Assert.assertEquals("FizzBuzz", jFizzBuzz.fizzBuzz(15));
        Assert.assertEquals("FizzBuzz", jFizzBuzz.fizzBuzz(30));
        Assert.assertEquals("2", jFizzBuzz.fizzBuzz(2));
        Assert.assertEquals("16", jFizzBuzz.fizzBuzz(16));

    }
}