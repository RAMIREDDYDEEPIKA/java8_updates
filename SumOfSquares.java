package com.functional;

import java.util.ArrayList;

import java.util.List;

public class SumOfSquares
{
    public static void main(String[] args) {
        List<Integer> numbers=new ArrayList<>();
        numbers.add(2);
        numbers.add(4);
        numbers.add(5);
        numbers.add(8);
        int squaresSum=numbers.stream().
                filter(n->n%2==0).
                map(n->n*n).
                reduce(0,(a,b) -> a+b);
        System.out.println("sum Of sqaues: "+squaresSum);
    }
}