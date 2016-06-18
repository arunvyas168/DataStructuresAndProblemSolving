package com.company;

public class Main {

    public static void main(String[] args) {
        String number = "38276";
        System.out.println(number);
        System.out.println(findNextHighest(number));
    }

    public static String findNextHighest(String num){
        char[] array = num.toCharArray();
        for(int i=num.length()-1;i>=0;i--){
            if(i!=0){
                if((Character.compare(num.charAt(i),num.charAt(i-1)))>0){
                    char temp = array[i];
                    array[i]= array[i-1];
                    array[i-1]=temp;
                    break;
                }
            }
        }
        return String.valueOf(array);
    }

}
