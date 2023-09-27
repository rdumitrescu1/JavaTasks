package com.java1;

public class StringReverse {
//Task2

    public static void main(String[] args) {
//1
        String stringToRevers = "I'm going to go to school today morning";
        StringBuilder ToReverse = new StringBuilder(stringToRevers);
        ToReverse.reverse();
        System.out.println(ToReverse);

//2
        StringBuffer stringToRevers2 = new StringBuffer("I'm going to go to school today morning");
        stringToRevers2.reverse();
        System.out.println(stringToRevers2);

//3
        String stringToRevers3 = "I'm going to go to school today morning";
        String Reversed3 = "";
        for (int i = stringToRevers3.length() - 1; i>=0; i-- )
        {
            Reversed3 += stringToRevers3.charAt(i);
        }
        System.out.println(Reversed3);


    }

}


