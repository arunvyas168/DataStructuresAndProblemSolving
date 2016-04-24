package com.company;

import java.util.Comparator;

/**
 * Created by arun on 4/24/16.
 */
public class ReverseSort implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o2 < o1)
        {
            return -1;
        }
        if (o2 > o1)
        {
            return 1;
        }
        return 0;
    }
}
