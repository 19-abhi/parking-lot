package org.sitafal.model;

import java.util.List;

public class ParkingFloor {
    private final int floorId;
    private List<ParkingSlot> parkingSlots;

    public ParkingFloor(int floorId) {
        this.floorId = floorId;
    }

    public int getFloorId() {
        return floorId;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
}
