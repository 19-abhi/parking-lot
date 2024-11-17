package org.sitafal.model;

import java.time.LocalDateTime;

public class Ticket {
    private int id;
    private int parkingLotId;
    private Vehicle vehicle;
    private LocalDateTime entryDateTime;
    private LocalDateTime exitTime;
    private int floorId;
    private int slotId;
    private PaymentType paymentType;
    private PaymentStatus paymentStatus;

    Ticket(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.entryDateTime = LocalDateTime.now();
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryDateTime() {
        return entryDateTime;
    }

    public void setEntryDateTime(LocalDateTime entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Ticket [id=" + id + ", vehicle=" + vehicle + ", entryDateTime=" + entryDateTime
                + ", exitTime=" + exitTime + ", floorId="+floorId+", slotId="+slotId+", paymentType="+paymentType+"]";
    }
}