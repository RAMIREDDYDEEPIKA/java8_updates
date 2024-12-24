package com.functional;

import java.util.function.Function;

public class CircleArea {

    public static void main(String[] args) {

        Function<Double,Double> findArea=radius->Math.PI*radius*radius;
        Double radius=5.0;
        Double area=findArea.apply(radius);
        System.out.println("Area of Circle is: "+area);
    }
}