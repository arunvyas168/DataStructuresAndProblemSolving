package com.company;

public class Main {

    public static void main(String[] args) {
        char[] set = {'a','b','c','d'};
        printIfBitIsSet(set);
    }

    public static void printIfBitIsSet(char[] set){
        /* Total number of combination is 2^set_size */
        long pow_set_size = (long) Math.pow(2,set.length);
        int counter, j;
        /* Run from counter 000..0 to 111..1 */
        for(counter = 0; counter < pow_set_size; counter++)
        {
            System.out.printf("{");
            /* Check if jth bit in the counter is set
             If set then pront jth element from set */
            for(j = 0; j < set.length; j++)
            {
                if((counter & (1<<j)) != 0)
                    System.out.print(set[j]);
            }
            System.out.printf("}");
            System.out.println();
        }

    }

}
