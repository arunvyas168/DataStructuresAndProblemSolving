package com.company;

public class Main {

    public static void main(String[] args) {

        Trie trie = new Trie();
        String[] dictionary =  {"are", "area", "base", "cat", "cater", "children", "basement"};
        //Construct the TRIE data-structure with the values in the dictionary
        for (String s : dictionary){
            trie.trieInsert(s);
        }
        //Test Search
        System.out.println(trie.trieSearch("cat"));
        //Test Delete and Search
        trie.trieDelete("cat");
        System.out.println(trie.trieSearch("cat"));
        System.out.println(trie.trieSearch("cater"));
        trie.trieInsert("cat");
        System.out.println(trie.trieSearch("cat"));

    /*
        Longest prefix matching
        Given a dictionary of words and an input string,
        find the longest prefix of the string which is also a word in dictionary.
        Let the dictionary contains the following words:
        {are, area, base, cat, cater, children, basement}

        Below are some input/output examples:
        --------------------------------------
        Input String            Output
        --------------------------------------
        caterer                 cater
        basemexy                base
        child                   < Empty >
    */

        String[] input = {"caterer", "basemexy", "child"};
        for (String s : input){
            System.out.println("Longest Prefix for "+s+" is ====> <"+trie.longestPrefixMatching(s)+">");
        }

    }
}
