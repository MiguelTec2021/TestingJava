package com.uttl.javatest.util;


import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void repeat_string_once() {
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));
    }

    @Test
    public void repeat_string_multipli_times() {
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3) );
    }
    @Test
    public void repeat_string_zero_times() {
        Assert.assertEquals("", StringUtil.repeat("hola", 0) );
    }
    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times() {
        StringUtil.repeat("hola", -1);
    }

    @Test
    public void string_empty() {
        Assert.assertEquals(true, StringUtil.isEmpty("Hello World"));
    }

    @Test
    public void quotes_empty_is_string_empty() {
        Assert.assertEquals(true, StringUtil.isEmpty(""));
    }

    @Test
    public void string_is_null(){
        Assert.assertEquals(true, StringUtil.isEmpty(null));
    }

    @Test
    public void quotes_with_space(){
        Assert.assertEquals(true, StringUtil.isEmpty(" "));
    }



}