package com.uttl.javatest.Password;

import org.junit.Test;

import static com.uttl.javatest.Password.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void weak_when_less_than_8_letters() {

        assertEquals(WEAK,PasswordUtil.assessPasword("123aa!"));
    }

    @Test
    public void weak_when_has_only_letters() {

        assertEquals(WEAK,PasswordUtil.assessPasword("abcdefgkj"));
    }

    @Test
    public void medium_when_has_letters_and_number() {

        assertEquals(MEDIUM,PasswordUtil.assessPasword("abcd12345"));
    }

    @Test
    public void strong_when_has_letters_numbers_and_symbols() {

        assertEquals(STRONG,PasswordUtil.assessPasword("abcd1234!"));
    }
}