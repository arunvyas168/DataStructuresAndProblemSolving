package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println("############# Example 1 ##############");
        String text = "My name is Arun";
        String arr[] = text.split(" ");
        for(String s : arr){
            System.out.println(s);
        }

        System.out.println("############# Example 2 ##############");
        String s = "I want to walk my dog, and why not?";
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        System.out.println("############# Example 3 ##############");
        text  = "My phone number is 7035050990";
        pattern = Pattern.compile("\\d");
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        System.out.println("############# Example 4 ##############");
        String str = "abcd1234";
        String[] part = str.split("(?<=\\D)(?=\\d)");
        System.out.println(part[0]);
        System.out.println(part[1]);

        System.out.println("############# Coffee Shop ##############");
        String input = "Starbucks SF,37.5209,-122.3340";
        String Arr[] = input.split(" ");
        String name = Arr[0];
        String location = Arr[1];
        String locArr[] = location.split(",");
        double Xvalue = Double.parseDouble(locArr[1]);
        double Yvalue = Double.parseDouble(locArr[2]);
        System.out.println(name + " "+ Xvalue+ "," +Yvalue);

    }
}
