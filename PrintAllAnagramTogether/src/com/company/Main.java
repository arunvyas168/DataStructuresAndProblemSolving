package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] input =  {"cat", "dog", "tac", "god", "act"};
        printAnagramsTogether(input);
    }

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
