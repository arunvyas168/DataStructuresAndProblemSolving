package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
        };
        int[] result = search(matrix, 29);
        if(result!=null){
            System.out.println("The element is at: matrix["+result[0]+","+result[1]+"]");
        }else {
            System.out.println("The element is not present in this matrix");
        }

    }

    public static int[] search(int[][] matrix, int key){
        int[] result = new int[2];
        int rowStart = 0;
        int columnEnd = matrix[0].length-1;

        while ((columnEnd>=0)&&(rowStart<matrix.length)){
            if(matrix[rowStart][columnEnd] == key){
                result[0] = rowStart;
                result[1] = columnEnd;
                return result;
            }else if(key<matrix[rowStart][columnEnd]){
                columnEnd--;
            }else{
                rowStart++;
            }
        }
        return null;
    }
}
