package org.sitafal.model;

public class EntryGate extends Gate {

    private final ParkingLot parkingLot;

    public EntryGate(ParkingLot parkingLot) {
        super(parkingLot);
        this.parkingLot = parkingLot;
    }

    public String generateTicket(){
        //<parking_lot_id>_<floor_no>_<slot_no>  -> PR1234_2_5
        return "PR" + parkingLot.getId() ;
    }

}
