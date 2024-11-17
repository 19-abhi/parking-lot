package org.sitafal.model;

public class Vehicle {
    private final VehicleType vehicleType;
    private final String vehicleNumber;
    private final String vehicleColor;

    public Vehicle(VehicleType vehicleType, String vehicleNumber, String vehicleColor) {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.vehicleColor = vehicleColor;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }
}
