package com.company;

public class Main {

    public static void main(String[] args) {
        int[] input = {2,3,7,8,10};
        int sum = 11;
        System.out.println("The value of isSubset is: "+isSubset(input,sum));
    }

    /*
    * if(j<input[j]){
    *   T[i][j] = T[i-1][j]
    * }else{
    *   T[i][j] = (T[i-1][j])||T[i-1][j-input[i]]
    * }
    * */
    public static boolean isSubset(int[] input, int sum){

        boolean[][] T = new boolean[input.length+1][sum+1];

        for (int i=0;i<input.length+1;i++){
            T[i][0] = true;
        }

        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >=  input[i - 1]) {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
                } else {
                    T[i][j] = T[i-1][j];
                }
                System.out.println(j);
            }
        }
        return T[input.length][sum];
    }

}
