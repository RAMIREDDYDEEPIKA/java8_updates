package com.functional;

@FunctionalInterface
interface CalculateSum
{
    int sum(int a,int b);
}

public class SumOfTwoInputs
{
    public static void main(String[] args)
    {
        CalculateSum addNumbers=(a,b) -> a+b;
        int result=addNumbers.sum(2,3);
        System.out.println("sum of two numbers: "+result);
    }
}