package com.company;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        String input = "aaaabbbc";
        char[] output = new char[input.length()];
        Comparator<Character> comp = new Character();
        PriorityQueue<Character> queue = new PriorityQueue<Character>(256,comp);
        Map<String,Character> map = new HashMap<String, Character>();
        for (int i = 0; i<input.length();i++){
            if (map.get(String.valueOf(input.charAt(i))) != null){

                Character c = map.get(String.valueOf(input.charAt(i)));
                c.setCount(c.getCount()+1);

            } else {
                map.put(String.valueOf(input.charAt(i)),new Character(String.valueOf(input.charAt(i)),1));
            }
        }
        for (Character value : map.values()) {
            queue.add(value);
        }
        while (!queue.isEmpty()){
            if(!reArrangeString(output,queue.poll())){
                System.out.println("Can not be re-arranged");
                break;
            }
        }
        System.out.println("The re-arranged string is: "+ String.valueOf(output));
    }


    public static boolean reArrangeString(char[] output,Character c){
        int length = output.length;
        for (int i = 0; i< length; i++){
            if (output[i] == '\0'){
                while ((c.getCount()!=0)&&(i < length)) {
                    output[i] = c.getValue().charAt(0);
                    c.setCount(c.getCount()-1);
                    i = i+2;
                }
                if (c.getCount() > 0){
                    return false;
                } else {
                    break;
                }
            }
        }
        return true;
    }


}
