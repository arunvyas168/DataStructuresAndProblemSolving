package com.company;

/**
 * Created by arun on 5/20/16.
 */
public enum VehicleType {
    Truck{
        public Vehicle getVehicle(){
            return new Truck();
        }
    },
    Car{
        public Vehicle getVehicle(){
            return new Car();
        }
    },
    ElectricCar{
        public Vehicle getVehicle(){
            return new ElectricCar();
        }
    };
    abstract Vehicle getVehicle();

}
