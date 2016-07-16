package com.company;

public class Main {

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.trieInsert("are");
        trie.trieInsert("area");
        trie.trieInsert("base");
        trie.trieInsert("cat");
        trie.trieInsert("cater");
        trie.trieInsert("basement");
        System.out.println(trie.trieSearch("cat"));
        trie.trieDelete("cat");
        System.out.println(trie.trieSearch("cat"));
        System.out.println(trie.trieSearch("cater"));
        trie.trieInsert("cat");
        System.out.println(trie.trieSearch("cat"));

    }
}
