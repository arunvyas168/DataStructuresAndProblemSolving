package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5},
                          {6, 7, 8, 9, 10},
                          {11,12,13,14,15}};
        //Expected op: { 1 2 3 4 5 10 15 14 13 12 11 6 7 8 9 }
        System.out.print("{ ");
        printSpiral(3,5,matrix);
        System.out.print("}");
    }

    public static void printSpiral(int rowEnd,int columnEnd,int[][] matrix){
        int rowStart = 0;
        int columnStart = 0;

        while ((rowStart<rowEnd)&&(columnStart<columnEnd)){
            for(int i=columnStart;i<columnEnd;i++){
                System.out.print(matrix[rowStart][i]+" ");
            }
            rowStart++;
            for(int i=rowStart;i<rowEnd;i++){
                System.out.print(matrix[i][columnEnd-1]+" ");
            }
            columnEnd--;
            if(rowStart<rowEnd){
                for (int i=columnEnd-1;i>=columnStart;i--){
                    System.out.print(matrix[rowEnd-1][i]+" ");
                }
                rowEnd--;
            }
            if(columnStart<columnEnd){
                for(int i=rowEnd-1;i>=rowStart;i--){
                    System.out.print(matrix[i][columnStart]+" ");
                }
                columnStart++;
            }
        }
    }
}
