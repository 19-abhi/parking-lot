package org.sitafal.model;

import org.sitafal.Exceptions.ParkingLotFullException;
import org.sitafal.Exceptions.VehicleNotFoundException;

import java.util.*;

public class ParkingLot {
    private final int parkingLotId;
    private final List<ParkingFloor> floorList;
    private final Set<Ticket> ticketSet;
    private Map<ParkingFloor, List<ParkingSlot>> floorParkingSlotMap;
    private Map<String, ParkingFloor> ticketFloorMap;
    private Map<String, ParkingSlot> ticketSlotMap;
    private Map<VehicleType, List<ParkingFloor>> vehicleParkingSlotMapFloorWise;

    ParkingLot() {
        this.floorList = new ArrayList<ParkingFloor>();
        this.ticketSet = new HashSet<Ticket>();
        this.vehicleParkingSlotMapFloorWise = new HashMap<VehicleType, List<ParkingFloor>> ();
        this.parkingLotId = 1234;
    }

    public int getId() {
        return parkingLotId;
    }

    public boolean isVehicleParked(String vechicleNumber) {
        return ticketSlotMap.containsKey(vechicleNumber);
    }

//    public Map<VehicleType, List<ParkingFloor>> getFreeSlots() {
//        var floorWiseVehicleSlots = new HashMap<VehicleType, List<ParkingFloor>>();
//        for (ParkingFloor floor : floorList) {
//            var parkingFloor = new ParkingFloor(floor.getFloorId());
//            var parkingSlots = new ArrayList<ParkingSlot>();
//            for (ParkingSlot slot : floor.getParkingSlots()) {
//                if (slot.isAvailable()) {
//
//                }
//            }
//            floorWiseVehicleSlots.put(floor.getFloorId(), slotWiseVehicle);
//        }
//        return floorWiseVehicleSlots;
//    }
// message to user that vehicle is released!! "Nikal Phali Fursat Mai Nikal";
    public Ticket releaseVehicle(Vehicle vehicle) throws VehicleNotFoundException {
        for (ParkingFloor floor : floorList) {
            for (ParkingSlot slot : floor.getParkingSlots()) {
                if (!slot.isAvailable() && slot.getTicket().getVehicle().equals(vehicle)) {
                    slot.setAvailable(true);
                    ticketSet.remove(slot.getTicket());
                    return slot.getTicket();
                }
            }
        }
        throw new VehicleNotFoundException("Invalid Ticket");
    }

    private void parkVehicle(Ticket ticket) throws ParkingLotFullException {
        if (isVehicleParked(ticket.getVehicle().getVehicleNumber())) {
            System.out.println("Parking lot " + parkingLotId + " has already been parked");
            return;
        }
        ParkingFloor parkingFloor = null;
        ParkingSlot parkingSlot = null;
        boolean isVehicleParked = false;
        for (ParkingFloor floor : floorList) {
            for (ParkingSlot slot : floor.getParkingSlots()) {
                if (slot.isAvailable()) {
                    parkingFloor = floor;
                    parkingSlot = slot;
                    slot.setAvailable(false);
                    ticket.setId(ticketSet.size() + 1);
                    ticket.setFloorId(parkingFloor.getFloorId());
                    ticketSet.add(ticket);
                    slot.setTicket(ticket);
                    isVehicleParked = true;
                    //
                    if(!vehicleParkingSlotMapFloorWise.containsKey(ticket.getVehicle().getVehicleType())) {
                        var parkingFloorList = new ArrayList<ParkingFloor>();
                        var parkingFloorNew = new ParkingFloor(parkingFloor.getFloorId());
                        var parkingSlotList = new ArrayList<ParkingSlot>();
                        parkingSlotList.add(parkingSlot);
                        parkingFloorList.add(parkingFloorNew);
                    }


                    break;
                }
            }
        }
        if (!isVehicleParked) {
            throw new ParkingLotFullException("Parking Lot Full");
        }
        ticketFloorMap.put(ticket.getVehicle().getVehicleNumber(), parkingFloor);
        ticketSlotMap.put(ticket.getVehicle().getVehicleNumber(), parkingSlot);
    }

    public List<ParkingFloor> getFloorList() {
        return floorList;
    }

    public Ticket generateTicket(Vehicle vehicle) throws ParkingLotFullException {
        var ticket = new Ticket(vehicle);
        parkVehicle(ticket);
        return ticket;
    }
}