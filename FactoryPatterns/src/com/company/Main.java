package com.company;

public class Main {

    public static void main(String[] args) {
	    VehicleFactory vf = new VehicleFactory();
        Vehicle v1 = vf.getVehicles(VehicleType.Car);
        v1.startEngine();
        Vehicle v2 = vf.getVehicles(VehicleType.Truck);
        v2.startEngine();
    }
}
