package com.company;

public class Main {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int k_window = 2;
        int n = arr.length-1;
        System.out.println("******Problem:1******");
        printCombination(arr, n, k_window);

        System.out.println("******Problem:2******");
        //char[] set = {'a','b','c','d'};
        //printIfBitIsSet(set);
        boolean[] B = new boolean[arr.length];
        subset(arr, 2, 0, 0, B);


        System.out.println("******Problem:3******");
        String str = "abcde";
        PrintCombinations(str, 2, "");
    }

    public static void printCombination(int arr[], int array_len, int k_window)
    {
        // A temporary array to store all combination one by one
        int[] data = new int[k_window];
        // Print all combination using temporary array 'data[]'
        combinationUtil(arr, data, 0, array_len, 0, k_window);
    }

    public static void combinationUtil(int arr[], int data[], int start,
                                       int end, int index, int k_window)
    {
        // Current combination is ready to be printed, print it
        //base case takes care of case when window-k is 0.
        if (index == k_window)
        {
            for (int j=0; j<k_window; j++)
                System.out.print(data[j]+" ");
            System.out.println("");
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        //for (int i=start; ((i<=end)); i++)
        for (int i=start; ((i<=end)&&(end-i+1 >= k_window-index)); i++)
        {
            data[index] = arr[i];
            //for excluding we do following (will not print 11,22,33,44)
            combinationUtil(arr, data, i+1, end, index+1, k_window);
            //for included we do following (will print 11,22,33,44)
            //combinationUtil(arr, data, i, end, index+1, k_window);
        }
    }


    public static void subset(int[] A, int k, int start, int currLen, boolean[] used) {

        if (currLen == k) {
            for (int i = 0; i < A.length; i++) {
                if (used[i] == true) {
                    System.out.print(A[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        if (start == A.length) {
            return;
        }
        // For every index we have two options,
        // 1.. Either we select it, means put true in used[] and make currLen+1
        used[start] = true;
        subset(A, k, start + 1, currLen + 1, used);
        // 2.. OR we dont select it, means put false in used[] and dont increase
        // currLen
        used[start] = false;
        subset(A, k, start + 1, currLen, used);
    }

    /* Inclusive method for eg: it prints both ab ba  */
    public static void PrintCombinations(String letters, int window, String prefix)
    {
        if (window == 0)
        {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < letters.length(); i++)
        {
            //first adds 'a' and sends to print and then 'b' and then 'c' ..
            String newPrefix = prefix + letters.charAt(i);
            //so window decreases and for each fun-call with a, b ,c, another char will be added
            PrintCombinations(letters, window - 1, newPrefix);
            //NOTE: if you want to exclude ab ba printing use char[] and increase start index.
        }
    }


/*
    public static void printIfBitIsSet(char[] set){
        long pow_set_size = (long) Math.pow(2,set.length);
        int counter, j;
        for(counter = 0; counter < pow_set_size; counter++)
        {
            System.out.printf("{");
            for(j = 0; j < set.length; j++)
            {
                if((counter & (1<<j)) != 0)
                    System.out.print(set[j]);
            }
            System.out.printf("}");
            System.out.println();
        }

    }
*/

}


/*
SAMPLE OUTPUT:
******Problem:1******
1 2
1 3
1 4
1 5
2 3
2 4
2 5
3 4
3 5
4 5
******Problem:2******
1 2
1 3
1 4
1 5
2 3
2 4
2 5
3 4
3 5
4 5
******Problem:3******
aa
ab
ac
ad
ae
ba
bb
bc
bd
be
ca
cb
cc
cd
ce
da
db
dc
dd
de
ea
eb
ec
ed
ee

Process finished with exit code 0


 */