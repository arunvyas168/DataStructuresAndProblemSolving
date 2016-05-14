package com.company;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String word = "qwertyuiopasdfghjklzxcvbnm";
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<word.length();i++){
            if(map.get(word.charAt(i))!=null){
                int count = map.get(word.charAt(i));
                count ++;
                map.put(word.charAt(i), count);
            }else{
                map.put(word.charAt(i), 1);
            }
        }

        Iterator it = map.entrySet().iterator();
        BigInteger denominator = BigInteger.valueOf(1);
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            denominator = denominator.multiply(factorial((int)pair.getValue()));
            it.remove();
        }
        System.out.println((factorial(word.length()).divide(denominator)));



    }

    public static BigInteger factorial(int n){
        BigInteger result = BigInteger.valueOf(1);
        for(int i=1;i<=n;i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}