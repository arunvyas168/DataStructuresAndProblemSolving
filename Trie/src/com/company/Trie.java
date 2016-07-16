package com.company;

/**
 * Created by arun on 7/16/16.
 */
public class Trie {
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void trieInsert(String word){
        TrieNode current = this.root;

        for (int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if (node == null){
                node = new TrieNode();
                current.children.put(c,node);
            }
            current = node;
        }
        current.isLeaf = true;
    }

    public boolean trieSearch(String word){
        TrieNode current = this.root;

        for (int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if (node == null){
                return false;
            }else {
                current = node;
            }
        }
        return current.isLeaf;
    }

    public boolean trieDelete(String word){
        return trieDelete_util(this.root,word,0);
    }
    private boolean trieDelete_util(TrieNode root, String word, int index){
        if (index == word.length()){
            if (!root.isLeaf){
                return false;
            }
            root.isLeaf = false;
            return (root.children.size() == 0);
        }

        char c = word.charAt(index);
        TrieNode node = root.children.get(c);
        if (node == null){
            return false;
        }
        boolean shouldDelete = trieDelete_util(node,word,index+1);

        if (shouldDelete){
            root.children.remove(c);
            return (root.children.size() == 0);
        }

        return false;

    }
}
