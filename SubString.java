package com.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SubString
{
    public static void main(String[] args) {

        List<String> inputStrings= new ArrayList<>();
        inputStrings.add("java");
        inputStrings.add("is");
        inputStrings.add("great");
        inputStrings.add("and");
        inputStrings.add("easiest");
        inputStrings.add("language");

        Predicate<String> strLength=word->word.length()>5;
        Predicate<String> subString=word->word.contains("easi");

        Predicate<String> combinedPredicates=strLength.and(subString);
        List<String> result=inputStrings.stream().filter(combinedPredicates).collect(Collectors.toList());

        System.out.println(result);
    }
}