package com.company;


public class Main {

    public static void main(String[] args) {
        Node root = null;
        root = addNodeToBST(root,40);
        root = addNodeToBST(root,20);
        root = addNodeToBST(root,60);
        root = addNodeToBST(root,50);
        root = addNodeToBST(root,70);
        root = addNodeToBST(root,10);
        root = addNodeToBST(root,30);
        printInOrder(root);

    }

    public static Node addNodeToBST(Node root, int data){
        if (root==null){
            return new Node(data);
        }
        if (root.data>data){
            root.left = addNodeToBST(root.left,data);
        } else {
            root.right = addNodeToBST(root.right,data);
        }
        return root;
    }

    public static void printInOrder(Node root){
        if (root == null){
            return;
        }
        printInOrder(root.left);
        System.out.println(root.data);
        printInOrder(root.right);
    }


}
