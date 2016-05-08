package com.company;


public class Main {

    public static void main(String[] args) {
        Node root = null;
        root = addNodeToBST(root,10);
        root = addNodeToBST(root,-10);
        root = addNodeToBST(root,30);
        root = addNodeToBST(root,8);
        root = addNodeToBST(root,25);
        root = addNodeToBST(root,60);
        root = addNodeToBST(root,6);
        root = addNodeToBST(root,9);
        root = addNodeToBST(root,28);
        root = addNodeToBST(root,78);
        printLowestCommonAncestorBST(root, 78,28);
    }


    public static Node addNodeToBST(Node root, int data){
        if (root==null){
            return new Node(data);
        }
        if (data<root.data){
            root.left = addNodeToBST(root.left,data);
        } else {
            root.right = addNodeToBST(root.right,data);
        }
        return root;
    }


    /*
        This Method does not check if the One of the element is not present in tree.
        Implementing that is ToDO
    */

    public static void printLowestCommonAncestorBST(Node root, int data1, int data2){

        if(root == null){
            System.out.println("No The Lowest Common Ancestor is present");
            return;
        } else if (root.data > Math.max(data1,data2)){
            printLowestCommonAncestorBST(root.left, data1,data2);
        }else if(root.data < Math.min(data1,data2)){
            printLowestCommonAncestorBST(root.right, data1,data2);
        }else {
            System.out.println("The Lowest Common Ancestor is: "+root.data);
        }
    }

}
