package org.sitafal.model;

import java.util.List;
import java.util.Map;

public class ParkingLot {
    private final int parkingLotId;
    List<ParkingFloor> floorList;
    Map<ParkingFloor, List<ParkingSlot>> floorParkingSlotMap;

    ParkingLot() {
        this.parkingLotId = 1234;
    }

    public int getId() {
        return parkingLotId;
    }

    public void processVehicle() {

    }

}