package org.sitafal.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingAdmin {

    private final ParkingLot parkingLot;
    Gate gate;

    ParkingAdmin(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public List<ParkingFloor> addParkingFloor(int numberOfFloor) {
        for (int i = 0; i < numberOfFloor; i++) {
            ParkingFloor parkingFloor = new ParkingFloor(parkingLot.getFloorList().size()+1);
            parkingLot.getFloorList().add(parkingFloor);
        }
        return parkingLot.getFloorList();
    }

    public List<ParkingFloor> addParkingSlot(int numberOfSlot) {
        // TOO: VehicleTypeDistribution logic
        for (var parkingFloor : parkingLot.getFloorList()) {
            var parkingSlotList = new ArrayList<ParkingSlot>();
            for (int i = 0; i < numberOfSlot; i++) {
                var parkingSlot = new ParkingSlot(parkingFloor.getParkingSlots().size()+1, VehicleType.BIKE);
                parkingSlotList.add(parkingSlot);
            }
            parkingFloor.setParkingSlots(parkingSlotList);
        }
        return parkingLot.getFloorList();
    }
}
