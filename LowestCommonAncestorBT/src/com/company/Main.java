package com.company;

import java.util.ArrayList;
import java.util.List;

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
        lca_1(root,78,28);
        System.out.println("The Lca_2 is: "+lca_2(root,78,28).data);
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
    * This Method uses extra space for storing the path to each node.
    * */
    public static void lca_1(Node root, int data1 , int data2){
        if (root==null){
            System.out.println("No Lowest Common Ancestor Present");
            return;
        }
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        lac_1_pathFinder(root,list1,data1);
        lac_1_pathFinder(root,list2, data2);
        for (int i=0;i<Math.min(list1.size(),list2.size())-1;i++){
            if (list1.get(i) == list2.get(i)){
                System.out.println("The Lowest Common Ancestor is: "+list1.get(i));
                return;
            }
        }
    }
    public static boolean lac_1_pathFinder(Node root, List list, int data){
        if(root == null){
            return false;
        }
        if((root.data == data)||(lac_1_pathFinder(root.left,list,data))||(lac_1_pathFinder(root.right,list,data))){
            list.add(root.data);
            return true;
        }
        return false;
    }

    /*
    * This Method is better No extra space.
    * Assumption: the data is present and valid
    * */
    public static Node lca_2(Node root, int data1 , int data2){
        if (root==null){
            return null;
        }
        if ((root.data == data1)||(root.data == data2)){
            return root;
        }
        Node left = lca_2(root.left, data1 , data2);
        Node right = lca_2(root.right, data1 , data2);
        if((left != null)&&(right !=null)){
            return root;
        }
        if ((left==null)&&(right==null)){
            return null;
        }
        return left !=null ? left : right;
    }

}
