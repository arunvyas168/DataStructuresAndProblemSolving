package com.company;

import java.text.DecimalFormat;
import java.util.Comparator;

/**
 * Created by arun on 4/24/16.
 */
public class Shop implements Comparator<Shop>{
    private String name;
    private Double XLocation;
    private Double YLocation;
    private Double distance;

    public Shop() {
    }

    public Shop(String name, Double XLocation, Double YLocation) {
        this.name = name;
        this.XLocation = XLocation;
        this.YLocation = YLocation;
    }

    public void setDistance(Double yourXLocation, Double yourYLocation){
        Double XAxisDistance =  Math.pow((Math.abs(yourXLocation)-Math.abs(this.XLocation)),2);
        Double YAxisDistance =  Math.pow((Math.abs(yourYLocation)-Math.abs(this.YLocation)),2);
        this.distance = Math.sqrt(XAxisDistance+YAxisDistance);
    }
    public Double getDistance() {
        return this.distance;
    }

    @Override
    public int compare(Shop o1, Shop o2) {
        return (o1.distance.compareTo(o2.distance));
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.0000");
        return (this.name+","+df.format(this.getDistance()));
    }
}
