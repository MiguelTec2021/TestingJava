package com.uttl.javatest.util;

public class StringUtil {

    public static String repeat(String str, int times){

        if (times < 0 ){
            throw new IllegalArgumentException("negative times not allowed");
        }

        String result = "";

        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }

    public static Boolean isEmpty(String str) {
        boolean resul = false;

        if (str == null){
            resul = true;
        }else if (str.trim() == ""){
            resul = true;
        }else if(!str.isEmpty() && str != ""){
            resul = true;
        }
        return resul;
    }

}
