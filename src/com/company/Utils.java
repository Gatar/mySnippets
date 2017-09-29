package com.company;

import java.util.function.Function;

public class Utils {

    public static int firstStartingWithE(String s1, String s2){
        if (s1.charAt(0) == 'E' && s2.charAt(0) != 'E') return -1;
        else if (s1.charAt(0) != 'E' && s2.charAt(0) == 'E') return 1;
        else return 0;
    }
    public static int lastStartingWithE(String s1, String s2){
        if (s1.charAt(0) == 'E' && s2.charAt(0) != 'E') return 1;
        else if (s1.charAt(0) != 'E' && s2.charAt(0) == 'E') return -1;
        else return 0;
    }

    public int doNothing(String s1, String s2){
        return 0;
    }

    public static String betterString(String s1, String s2, TwoStringPredicate twoStringPredicate){
        return twoStringPredicate.isBetter(s1, s2) ? s1 : s2;
    }
}
