package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<Character,Integer> characterToIndexMap = new HashMap<>();
    public static void populateHashMap(){
        characterToIndexMap.put('a',0);
        characterToIndexMap.put('b',1);
        characterToIndexMap.put('c',2);
        characterToIndexMap.put('d',3);
        characterToIndexMap.put('e',4);
        characterToIndexMap.put('f',5);
        characterToIndexMap.put('g',6);
        characterToIndexMap.put('h',7);
        characterToIndexMap.put('i',8);
        characterToIndexMap.put('j',9);
        characterToIndexMap.put('k',10);
        characterToIndexMap.put('l',11);
        characterToIndexMap.put('m',12);
        characterToIndexMap.put('n',13);
        characterToIndexMap.put('o',14);
        characterToIndexMap.put('p',15);
        characterToIndexMap.put('q',16);
        characterToIndexMap.put('r',17);
        characterToIndexMap.put('s',18);
        characterToIndexMap.put('t',19);
        characterToIndexMap.put('u',20);
        characterToIndexMap.put('v',21);
        characterToIndexMap.put('w',22);
        characterToIndexMap.put('x',23);
        characterToIndexMap.put('y',24);
        characterToIndexMap.put('z',25);
    }

    public static void main(String[] args) {
        populateHashMap();
        String input1 = "geeksforgeeks";
        String input2 = "forgeeksgeeks";
        System.out.println(isAnagramsCountMethod(input1,input2));
        System.out.println(isAnagramsSortMethod(input1,input2));

    }

    public static boolean isAnagramsCountMethod(String s,String t)
    {
        if(s.length()!=t.length()){
            return false;
        }
        int[] letters = new int[26];
        Arrays.fill(letters,0);
        for(int i=0;i<s.length();i++){
            int sIndex = characterToIndexMap.get(s.charAt(i));
            int tIndex = characterToIndexMap.get(t.charAt(i));
            letters[sIndex]++;
            letters[tIndex]--;
        }
        for(int i : letters){
            if (i!=0){
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramsSortMethod(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        char[]sArray = s.toCharArray();
        char[]tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        for(int i=0;i<s.length();i++){
            if (sArray[i] != tArray[i]){
                return false;
            }
        }
        return true;
    }


}
