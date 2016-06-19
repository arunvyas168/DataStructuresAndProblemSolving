package com.company;

/*
print all the characters present in the given string only once in a reverse order.
Time & Space complexity should not be more than O(N).
e.g.
1)Given a string aabdceaaabbbcd
the output should be - dcbae

2)Sample String - aaaabbcddddccbbdaaeee
 Output - eadbc

3)I/P - aaafffcccddaabbeeddhhhaaabbccddaaaa
O/P - adcbhef
 */

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        String input1 = "aabdceaaabbbcd";
        String input2 = "aaaabbcddddccbbdaaeee";
        String input3 = "aaafffcccddaabbeeddhhhaaabbccddaaaa";
        printReverseRemoveDuplicates(input1);
        printReverseRemoveDuplicates(input2);
        printReverseRemoveDuplicates(input3);
    }


    public static void printReverseRemoveDuplicates(String input){
        String output = "";
        HashSet<Character> set = new HashSet<>();
        for(int i=input.length()-1;i>=0;i--){
            if(!set.contains(input.charAt(i))){
                set.add(input.charAt(i));
                output+=input.charAt(i);
            }
        }
        System.out.println(output);
    }
}
