package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] garden = {  {5, 7, 8, 6, 3},
                {0, 0, 7, 0, 4},
                {4, 6, 3, 4, 9},
                {3, 1, 0, 5, 8}
        };
        System.out.println(getNumberOfCarrot(garden));
    }
    /*
        Calculate the sum of carrots
    */
    public static int getNumberOfCarrot(int[][]garden){
        int[] mid = findMid(garden);
        int sum = 0;
        while (garden[mid[0]][mid[1]]!=0){
            sum += garden[mid[0]][mid[1]];
            garden[mid[0]][mid[1]]=0;
            mid = getNextSquare(garden,mid);
        }
        return sum;
    }

    /*
       Find the middle appropriate square
   */
    public static int[] findMid(int[][]garden){
        int[] mid = new int[2];
        int row = garden.length;
        int column = garden[0].length;

        if ((row%2==1)&&(row%2==1)){            //If both row and column are odd we can find exact mid
            mid[0] = row/2;
            mid[1] = column/2;
            return mid;
        }else if((row%2==1)&&(column%2==0)){    //If row is odd but and column is even.
            mid[0] = row/2;
            if(garden[row/2][column/2]<garden[row/2][(column/2)-1]){
                mid[1] = (column/2)-1;
            }else {
                mid[1] = column/2;
            }
            return mid;
        }else if((row%2==0)&&(column%2==1)){    //If column is odd but and row is even.
            mid[1] = column/2;
            if(garden[row/2][column/2]<garden[(row/2)-1][(column/2)]){
                mid[0] = (row/2)-1;
            }else {
                mid[0] = row/2;
            }
            return mid;
        }else {                                 //If both row and column is even.
            int max = 0;
            int[] index = new int[2];
            for(int i=row/2;i>=(row/2)-1;i--){
                for(int j=column/2;j>=(column/2)-1;j--){
                    if(max<garden[i][j]){
                        max = garden[i][j];
                        index[0]=i;
                        index[1]=j;
                    }
                }
            }
            return index;
        }

    }

    /*
        Find the next Square with maximum number.
    */
    public static int[] getNextSquare(int[][]garden,int[]mid){
        int max = 0;
        int i = mid[0];
        int j = mid[1];
        if ((j+1<garden[0].length)&&(max<garden[i][j+1])){
            max = garden[i][j+1];
            mid[0]=i;
            mid[1]=j+1;
        }
        if ((j-1>=0)&&(max<garden[i][j-1])){
            max = garden[i][j-1];
            mid[0]=i;
            mid[1]=j-1;
        }
        if ((i+1<garden.length)&&(max<garden[i+1][j])){
            max = garden[i+1][j];
            mid[0]=i+1;
            mid[1]=j;
        }
        if ((i-1>=0)&&(max<garden[i-1][j])){
            mid[0]=i-1;
            mid[1]=j;
        }
        return mid;
    }

}
