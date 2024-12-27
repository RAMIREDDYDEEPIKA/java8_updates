package com.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListFiltering {

    public static void main(String[] args) {

        List<String> inputString=new ArrayList<>();
        inputString.add("hello");
        inputString.add("good mrg");
        inputString.add("Ashika");
        inputString.add("ashu");

        List<String> filteredList=inputString.stream()
                .filter(word->word.toUpperCase().startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(filteredList);
    }
}