package org.sitafal.model;

import org.sitafal.Exceptions.ParkingLotFullException;
import org.sitafal.Exceptions.VehicleNotFoundException;

public class ExitGate extends Gate {
    private final ParkingAttendant parkingAttendant;

    public ExitGate(ParkingAttendant parkingAttendant) {
        this.parkingAttendant = parkingAttendant;
    }

    public String releaseVehicle(Vehicle vehicle)  {
        //<parking_lot_id>_<floor_no>_<slot_no>  -> PR1234_2_5
        try {
            var ticket = parkingAttendant.releaseVehicle(vehicle);
            return "Unparked vehicle with Registration Number:" + ticket.getVehicle().getVehicleNumber() +  "and Color: "+ticket.getVehicle().getVehicleColor();
        } catch (VehicleNotFoundException e) {
            return e.getMessage();
        }
    }
}
