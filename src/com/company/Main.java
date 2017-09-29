package com.company;

import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private final static String[] testString = {"Jasiek", "Ewaryst", "Adam", "Mariola", "żydokomuna", "Edmund", "123", "Twój stary to twoja stara", "Ni"};

    public static void main(String[] args) {
        ImmutableList<TestProperty> list = ImmutableList.<TestProperty>builder()
                .add(TestProperty.fetchProperty("prop", true, () -> "DUPA"))
                .add(TestProperty.fetchProperty("kroperrty", false, () -> "Anty-dupa"))
                .build();

        Map<String,String> map = list.stream().collect(Collectors.toMap(TestProperty::getProperty, TestProperty::getData));
        int i = 3;
    }

    public static void old() {
        // write your code here

        //Sortowanie po liczbie np. długości
        Arrays.sort(testString, (s1, s2) -> s1.length() - s2.length());
        Arrays.sort(testString, Comparator.comparingInt(String::length));

        //j/w ale na odwrót
        Arrays.sort(testString, (s1, s2) -> s2.length() - s1.length());

        // Sortowanie alfabetyczne po 1 znaku
        Arrays.sort(testString, (s1, s2) -> s1.charAt(0) - s2.charAt(0));
        Arrays.sort(testString, Comparator.naturalOrder());

        //sortowanie po występowaniu 'e'
        Arrays.sort(testString, (s1, s2) -> {
            if (s1.charAt(0) == 'E' && s2.charAt(0) != 'E') return -1;
            else if (s1.charAt(0) != 'E' && s2.charAt(0) == 'E') return 1;
            else return 0;
        });
        Arrays.sort(testString, (s1, s2) -> Utils.firstStartingWithE(s1, s2));
        Arrays.sort(testString, Utils::firstStartingWithE);
        Arrays.sort(testString, Utils::lastStartingWithE);

        System.out.println(Arrays.asList(testString));

        //Two String predicate
        System.out.println(Utils.betterString("ababababababa", "zxzxzxzxzxzxzxzx", (a, b) -> a.length() > b.length()));
    }
}
