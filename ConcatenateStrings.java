package com.functional;

import java.util.function.BiFunction;

public class ConcatenateStrings {

    public static void main(String[] args) {

        BiFunction<String,String,String> concateStrings=(str1,str2)->str1+" "+str2;
        String word1="java";
        String word2="programming";
        String concatenated= concateStrings.apply(word1,word2);
        System.out.println(concatenated);
    }
}