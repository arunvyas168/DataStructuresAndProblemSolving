package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[]source = {"ans = 0",
                "for i in range(n):",
                "    for j in range(n):",
                "    //DB 3//for j in range(1, n):",
                "    //DB 2//for j in range(n + 1):",
                "        ans += 1",
                "return ans"};
        int challengeId = 3;
        String[] result = taskMaker(source,challengeId);
        for (int i=0; i<result.length;i++){
            System.out.println(result[i]);
        }
    }


    public static String[] taskMaker(String[] source, int challengeId) {
        String lookupString = "//DB "+challengeId+"//";
        String nonSpecialString = "//DB ";
        List<String> list = new ArrayList<String>();
        int index = 0;
        for(int i=0;i<source.length;i++){
            if(source[i].contains(nonSpecialString)){
                if(source[i].contains(lookupString)){
                    String[] insert = source[i].split(lookupString);
                    String x = replace(list,index-1,insert[1]);
                    list.remove(index-1);
                    list.add(x);
                }
            }else{
                list.add(source[i]);
                index++;
            }

        }

        String[] result = new String[list.size()];
        return source;

    }

    public static String replace(List list, int index, String insert){
        String tab = "";
        String source = list.get(index).toString();
        for(int i =0; i<source.length();i++){
            if(source.charAt(i) == ' '){
                tab+=source.charAt(i);
            }else{
                break;
            }
        }
        insert = tab+insert;
        return insert;
    }


}
