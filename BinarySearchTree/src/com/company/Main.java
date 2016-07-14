package com.company;


import java.util.LinkedList;
import java.util.Queue;

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
        root = addNodeToBST(root,25);
        //root = addNodeToBST(root,22);
        System.out.println("The Diameter of the tree in O(n): "+ diameter(root));
        System.out.println("The Diameter of the tree in O(n^2): "+ diameter_2(root));
        System.out.println("The min depth is: "+minDepth(root)+" and the max depth is: "+maxDepth(root));
        if(isBalanced(root)){
            System.out.println("The tree is balanced binary tree");
        } else {
            System.out.println("The tree is NOT balanced");
        }
        //root.left.right.left.data = 800;
        //System.out.println("The last value is: "+root.left.right.left.data);
        System.out.println("The minimum value in the BST is: "+findBSTMinNode(root));
        deleteNodeBST(root,30);
        printInOrder(root);
        boolean hasSum = hasPathSum(root, 150);
        if (hasSum){
            System.out.println("This tree has a path that sums to: 150");
        }else{
            System.out.println("This tree does not have path that sums to: 150");
        }
        hasSum = hasPathSum(root, 10);
        if (hasSum){
            System.out.println("This tree has a path that sums to: 10");
        }else{
            System.out.println("This tree does not have path that sums to: 10");
        }
        boolean isABst = isBST(root);
        if (isABst){
            System.out.println("The given tree is a Binary search tree");
        } else {
            System.out.println("The given tree is not a Binary search tree");
        }

        printBFSTraversal(root);
        printLevelBFSTraversal(root);

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

    public static void printInOrder(Node root){
        if (root == null){
            return;
        }
        printInOrder(root.left);
        System.out.println(root.data);
        printInOrder(root.right);
    }

    public static boolean hasPathSum(Node root, int sum){
        if (root == null){
            return (sum == 0);
        }
        int subSum = sum - root.data;
        return((hasPathSum(root.left,subSum))|| (hasPathSum(root.right,subSum)));
    }



    public static boolean isBST(Node root){

        return isBSTUtil(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTUtil(Node root, int min, int max){
        if (root == null){
            return true;
        }
        if ((root.data<min || root.data>max)) {
            return (false);
        } else {
            return ((isBSTUtil(root.left,min,root.data)) && (isBSTUtil(root.right,root.data+1,max)));
        }
    }

    public static void printBFSTraversal(Node root){
        System.out.println("Printing the Tree using Breadth First Search ");
        Queue<Node> queue = new LinkedList<Node>();
        if (root == null){
            System.out.println("Tree is empty");
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.remove();
            System.out.println(temp.data);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

    }

    public static void printLevelBFSTraversal(Node root){
        System.out.println("Printing each level of Tree using Breadth First Search ");
        Queue<Node> queue = new LinkedList<Node>();
        if (root == null){
            System.out.println("Tree is empty");
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int levelQueue = queue.size();
            while (levelQueue>0){
                Node temp = queue.remove();
                System.out.print(temp.data+" ");
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
                levelQueue--;
            }
            System.out.println();
        }
    }

    public static int findBSTMinNode(Node root){
        if (root == null){
            System.out.printf("Error: The tree is empty");
            return -1;
        }
        while (root.left != null){
            root = root.left;
        }
        return root.data;
    }

    public static Node deleteNodeBST(Node root, int key){
        if (root == null){
            return null;
        }

        if (key < root.data){
            root.left = deleteNodeBST(root.left,key);
        }else if(key > root.data){
            root.right = deleteNodeBST(root.right,key);
        }else {
            if (root.left == null){
                return root.right;
            } else if (root.right == null){
                return root.left;
            }
            root.data = findBSTMinNode(root.right);
            root.right = deleteNodeBST(root.right,root.data);
        }
        return root;

    }

    public static int maxDepth(Node root){
        if (root == null){
            return 0;
        }
        int ldepth = maxDepth(root.left);
        int rdepth = maxDepth(root.right);
        if (ldepth>rdepth){
            return ldepth+1;
        } else {
            return rdepth+1;
        }
    }
    public static int minDepth(Node root){
        if (root == null){
            return 0;
        }
        int ldepth = minDepth(root.left);
        int rdepth = minDepth(root.right);
        if (ldepth>rdepth){
            return rdepth+1;
        } else {
            return ldepth+1;
        }
    }

    public static boolean isBalanced(Node root){
        if ((maxDepth(root))-(minDepth(root)) <=1){
            return true;
        } else {
            return false;
        }
    }

    /*
    ***************************************** Diameter of a Binary Tree O(n) ******************************************
    */

    /*
        This does it in O(n)
    */
    public static int diameter(Node root){
        Height height = new Height();
        return diameter_util(root,height);
    }
    public static int diameter_util(Node root,Height height ){
        if (root == null){
            height.h = 0;
            return 0;
        }

        Height lHeight = new Height();
        Height rHeight = new Height();

        lHeight.h++;
        rHeight.h++;
        int lDiameter = diameter_util(root.left,lHeight);
        int rDiameter = diameter_util(root.right,rHeight);

        height.h = Math.max(lHeight.h,rHeight.h)+1;

        return  Math.max((lHeight.h+rHeight.h+1),(Math.max(lDiameter,rDiameter)));

    }

    static class Height
    {
        public int h;
        public Height(){
            this.h=0;
        }
    }

    /*
    ***************************************** Diameter of a Binary Tree O(n^2) ******************************************
    */

    /*
        This does it in O(n^2)
    */

    public static int diameter_2(Node root){
        if (root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        int lDiameter  = diameter_2(root.left);
        int rDiameter = diameter_2(root.right);
        return Math.max((leftHeight+rightHeight+1),Math.max(lDiameter,rDiameter));
    }

}
