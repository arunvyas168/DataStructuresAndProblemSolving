package com.company;

public class Main {

    public static void main(String[] args) {
	    String sentence = "Arun loves Ice Cream";
        System.out.println(reverseSentence(sentence));
    }

    public static String reverseSentence(String input){
        String output = "";
        String reverse = reverseString(input);
        String[] array = reverse.split(" ");
        output = reverseString(array[0]);
        for (int i=1;i<array.length;i++){
            output = output+" "+reverseString(array[i]);
        }

        return output;
    }

    public static String reverseString(String string){
        char[] array = string.toCharArray();
        int start =0;
        int end  = array.length-1;
        while (start<=end){
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return String.copyValueOf(array);
    }
}
