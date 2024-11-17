package org.sitafal.model;

public class ParkingSlot {
    private final int id;
    private Ticket ticket;
    private VehicleType vehicleType;
    private boolean isAvailable;

    public ParkingSlot(int id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public int getId() {
        return id;
    }
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
        this.ticket.setSlotId(id);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
