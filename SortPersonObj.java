package com.functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person{

    String name;
    int age;
    String sal;

    public Person(String name,int age,String sal){
        this.name=name;
        this.age=age;
        this.sal=sal;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sal='" + sal + '\'' +
                '}';
    }
}
public class SortPersonObj {

    public static void main(String[] args) {

        List<Person> personList=new ArrayList<>();
        personList.add(new Person("Pooji",20,"30000"));
        personList.add(new Person("Harshi",25,"34000"));
        personList.add(new Person("Nisha",23,"35000"));
        personList.add(new Person("Usha",22,"43000"));

        Collections.sort(personList, Comparator.comparingInt(p -> p.age));

        System.out.println("person data based on age sorting:");
        for(Person person:personList){
            System.out.println(person);
        }
    }
}