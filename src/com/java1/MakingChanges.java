package com.java1;


//Task3
class Person{
    String name;
    int age;
}

public class MakingChanges {

    public static void changeIdentities(Person p1, Person p2){

        if(p1 != null && p2 != null) {
            String aux = p1.name;
            p1.name = p2.name;
            p2.name = aux;

            int temp = p1.age;
            p1.age = p2.age;
            p2.age = temp;
        }
        else System.out.println("P1 or p2 null");
    }

    public static void main(String[] args) {

        Person p1 = new Person();
        p1.name="Andrei";
        p1.age=25;

        Person p2 = new Person();
        p2.name="Alex";
        p2.age=20;

        System.out.println("Before swap: ");
        System.out.println("Name: " +p1.name +" Age: " + p1.age);
        System.out.println("Name: " + p2.name +" Age:" +p2.age);

        changeIdentities(p1,p2);

        System.out.println("After swap: ");
        System.out.println("Name: " +p1.name +" Age: " + p1.age);
        System.out.println("Name: " + p2.name +" Age:" +p2.age);

    }
}


