package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String input1 = "{}{}{}{{}}{{{}}}}";
        System.out.println(isBalanced(input1));
        String input2 = "{}{}{}{{}}{{{}}}";
        System.out.println(isBalanced(input2));
    }

    public static boolean isBalanced(String input){
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<input.length();i++){
            if((Character.compare(input.charAt(i),'{'))==0){
                stack.push(input.charAt(i));
            }else if((Character.compare(input.charAt(i),'}'))==0){
                if (!stack.empty()) {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        if (stack.empty()){
            return true;
        }
        return false;
    }
}
