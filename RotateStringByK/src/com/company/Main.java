package com.company;

public class Main {

    public static void main(String[] args) {
	    String input = "Vyasnarayanan";
        int k = 4;
        String output = stringRotate(input, k);
        System.out.println("The Rotated string is: "+ output);
    }

    public static String stringRotate(String str, int k){
        if (k > str.length()){
            System.out.println("Value of K is bigger than the string. Can not be rotated");
            return str;
        }
        char[] array = str.toCharArray();
        int length = str.length();
        stringRev(array,0,length-1);
        stringRev(array,0,k-1);
        stringRev(array,k,length-1);
        return String.valueOf(array);
    }

    public static void stringRev(char[] array, int start, int end){
        char temp;
        while (start <= end){
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

}
