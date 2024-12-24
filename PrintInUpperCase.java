package com.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PrintInUpperCase {

    public static void main(String[] args) {

        List<String> inputString=new ArrayList<>();
        inputString.add("you");
        inputString.add("are");
        inputString.add("happy");
        inputString.add("with");
        inputString.add("tensions");

        Consumer<String> inUppercase=word-> System.out.println(word.toUpperCase());
        inputString.forEach(inUppercase);
    }
}