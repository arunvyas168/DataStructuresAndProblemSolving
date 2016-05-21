package com.company;

/**
 * Created by arun on 5/20/16.
 */
public class VehicleFactory {
    public Vehicle getVehicles(VehicleType kind){
        return kind.getVehicle();
    }
}
