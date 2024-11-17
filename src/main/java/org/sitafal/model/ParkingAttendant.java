package org.sitafal.model;

import org.sitafal.Exceptions.ParkingLotFullException;
import org.sitafal.Exceptions.VehicleNotFoundException;

public class ParkingAttendant {

    private final ParkingLot parkingLot;
    Gate gate;

    ParkingAttendant(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket processVehicle(Vehicle vehicle) throws ParkingLotFullException {
        return parkingLot.generateTicket(vehicle);
        //System.out.println(ticket.toString());
//        System.out.println("Ticket: Id=" + ticket.getId()+ " parked at floorId="+ ticket.getFloorId() + " slotId="+ticket.getSlotId());
    }

    public Ticket releaseVehicle(Vehicle vehicle) throws VehicleNotFoundException {
        return parkingLot.releaseVehicle(vehicle);
    }

    public int getParkingLotId() {
        return parkingLot.getId();
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

}