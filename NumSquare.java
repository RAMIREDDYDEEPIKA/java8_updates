package com.functional;

interface CalculateSquare{

    int square(int number);

    default void message(int number){
        int result=square(number);
        System.out.println("square of "+number+" is "+result);
    }
}
public class NumSquare {

    public static void main(String[] args) {

        CalculateSquare findSquare=number -> number*number;
        findSquare.message(5);
    }
}