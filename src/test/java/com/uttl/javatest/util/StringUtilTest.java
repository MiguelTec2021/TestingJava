package com.uttl.javatest.util;


public class StringUtilTest {
    public static void main(String[] args) {

        //String result = StringUtil.repeat("hola", 3);
        //assertEquals(result, "holaholahola");

        assertEquals(StringUtil.repeat("hola", 3), "holaholahola");

        //System.out.println(result);

        //System.out.println(result2);
        assertEquals(StringUtil.repeat("hola", 1), "hola");
    }

    private static void assertEquals(String actual, String expected) {
        if (!actual.equals(expected)){
            throw new RuntimeException(actual + " is not equal to expected " + expected);
        }
    }
}