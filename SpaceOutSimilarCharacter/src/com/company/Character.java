package com.company;

import java.util.Comparator;

/**
 * Created by arun on 4/30/16.
 */
public class Character implements Comparator<Character> {
    private String value;
    private Integer count;

    public Character(){

    }

    public Character(String value, Integer count) {
        this.value = value;
        this.count = count;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public int compare(Character o1, Character o2) {
        return o2.count.compareTo(o1.count);
    }

    @Override
    public String toString() {
        return "The string is: " +this.value+ " and the count is: "+ this.count;
    }
}
