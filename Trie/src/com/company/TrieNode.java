package com.company;

import java.util.HashMap;

/**
 * Created by arun on 7/16/16.
 */
public class TrieNode {
    HashMap<Character,TrieNode> children;
    boolean isLeaf;
    public TrieNode(){
        this.children = new HashMap<Character, TrieNode>();
        this.isLeaf = false;
    }
}
