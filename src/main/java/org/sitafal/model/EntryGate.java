package org.sitafal.model;

import org.sitafal.Exceptions.ParkingLotFullException;

public class EntryGate extends Gate {

    private final ParkingAttendant parkingAttendant;

    public EntryGate(ParkingAttendant parkingAttendant) {
        this.parkingAttendant = parkingAttendant;
    }

    public String generateTicket(Vehicle vehicle)  {
        //<parking_lot_id>_<floor_no>_<slot_no>  -> PR1234_2_5
        try {
            var ticket = parkingAttendant.processVehicle(vehicle);
            return "Parked vehicle. Ticket ID: PR1234_"+ticket.getFloorId()+"_"+ticket.getSlotId();
        } catch (ParkingLotFullException e) {
            return e.getMessage();
        }
    }

}
