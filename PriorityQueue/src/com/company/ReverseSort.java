package com.company;

import java.util.Comparator;

/**
 * Created by arun on 4/24/16.
 */
public class ReverseSort implements Comparator<Double> {
    @Override
    public int compare(Double o1, Double o2) {
        return o1.compareTo(o2);
    }
}
