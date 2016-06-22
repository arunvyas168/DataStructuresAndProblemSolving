package com.company;

/*
You are given a dictionary, in the form of a file that contains one word per line. E.g.,
        abacus
        deltoid
        gaff
        giraffe
        microphone
        reef
        qar
        You are also given a collection of letters. E.g., {a, e, f, f, g, i, r, q}.
        The task is to find the longest word in the dictionary that can be spelled with the collection of
        letters. For example, the correct answer for the example values above is “giraffe”. (Note that
        “reef” is not a possible answer, because the set of letters contains only one “e”.)
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static Map<Character,Integer> letterMap = new HashMap<>();
    public static List<String> wordList = new ArrayList<>();

    public static void main(String[] args) {
        populateLetterMap();
        populateWordList();
        String word = findLongestWord();
        System.out.println(word);
    }
    public static void populateLetterMap(){
        letterMap.put('a',1);
        letterMap.put('e',1);
        letterMap.put('f',2);
        letterMap.put('g',1);
        letterMap.put('i',1);
        letterMap.put('r',1);
        letterMap.put('q',1);
    }
    public static void populateWordList(){
        wordList.add("abacus");
        wordList.add("deltoid");
        wordList.add("gaff");
        wordList.add("giraffe");
        wordList.add("microphone");
        wordList.add("reef");
        wordList.add("qar");
    }
    public static String findLongestWord(){
        String output = "";
        int maxLength = 0;
        boolean isValidString = false;
        for(String str : wordList){
            for (int i=0;i<str.length();i++){
                if(!letterMap.containsKey(str.charAt(i))){
                    isValidString = false;
                    break;
                }else{
                    Integer temp =  letterMap.get(str.charAt(i));
                    if(--temp !=0) {
                        letterMap.put(str.charAt(i), temp);
                    }
                    isValidString = true;
                }
            }
            if ((maxLength < str.length()) &&(isValidString == true)) {
                maxLength = str.length();
                output = str;
            }
        }

        return output;
    }
}
