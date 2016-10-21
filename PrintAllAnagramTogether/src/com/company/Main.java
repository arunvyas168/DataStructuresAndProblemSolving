package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] input =  {"cat", "dog", "tac", "god", "act"};
        printAnagramsTogether(input);
        printAnagramsTogether_leetcode(input);
    }

    /**
     * The complexity is th O(nm) where m is the average length of strings
     * and n is the number of string
     * Building the sb is of constant time
     * @param input
     */
    public static void printAnagramsTogether_leetcode(String[] input){
        HashMap<String,ArrayList<String>> result  = new HashMap<>();
        ArrayList<String> list = null;
        for (String str : input){
            String anagram = anagramBuilder(str);
            if (!result.containsKey(anagram)){
                list = new ArrayList<>();
                list.add(str);
                result.put(anagram,list);
            }else {
                ArrayList<String> temp = result.get(anagram);
                temp.add(str);
                result.put(anagram,temp);
            }
        }

        for(Map.Entry<String, ArrayList<String>> entry : result.entrySet()){
            ArrayList<String> group = entry.getValue();
            for (String s : group){
                System.out.print(s+" ");
            }
        }
        System.out.println();
    }

    public static String anagramBuilder(String str){
        int[] anagram = new int[256];
        for (int i=0;i<str.length();i++){
            anagram[str.charAt(i)]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : anagram){
            sb.append(i);
        }
        return sb.toString();
    }


    /**
     * The complexity is th O(nmLogm) where m is the average length of strings
     * and n is the number of string
     * @param input
     */
    public static void printAnagramsTogether(String[] input){
        Text t1;
        Comparator<Text> comp = new Text();
        Queue<Text> priorityQueue = new PriorityQueue<>(input.length,comp);
        for(int i=0; i<input.length;i++){
            t1 = new Text(buildSortedString(input[i]),i);
            priorityQueue.add(t1);
        }
        while (!priorityQueue.isEmpty()){
            System.out.println(input[priorityQueue.poll().index]);
        }

    }

    public static String buildSortedString(String s){
        char[]array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    public static class Text implements Comparator<Text>{
        private String value;
        private int index;
        public Text(){
        }
        public Text(String value, int index){
            this.value = value;
            this.index = index;
        }
        @Override
        public int compare(Text t1, Text t2){
            return t1.value.compareTo(t2.value);
        }
    }


}
