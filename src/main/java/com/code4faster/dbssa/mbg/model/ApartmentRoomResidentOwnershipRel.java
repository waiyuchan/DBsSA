package com.code4faster.dbssa.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class ApartmentRoomResidentOwnershipRel implements Serializable {
    private Integer id;

    private Integer apartmentResidentId;

    private Integer apartmentRoomId;

    private Integer apartmentResidentReservationId;

    private Integer apartmentRentalOrderId;

    private Integer status;

    private Date checkinTime;

    private Date checkoutTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApartmentResidentId() {
        return apartmentResidentId;
    }

    public void setApartmentResidentId(Integer apartmentResidentId) {
        this.apartmentResidentId = apartmentResidentId;
    }

    public Integer getApartmentRoomId() {
        return apartmentRoomId;
    }

    public void setApartmentRoomId(Integer apartmentRoomId) {
        this.apartmentRoomId = apartmentRoomId;
    }

    public Integer getApartmentResidentReservationId() {
        return apartmentResidentReservationId;
    }

    public void setApartmentResidentReservationId(Integer apartmentResidentReservationId) {
        this.apartmentResidentReservationId = apartmentResidentReservationId;
    }

    public Integer getApartmentRentalOrderId() {
        return apartmentRentalOrderId;
    }

    public void setApartmentRentalOrderId(Integer apartmentRentalOrderId) {
        this.apartmentRentalOrderId = apartmentRentalOrderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(Date checkinTime) {
        this.checkinTime = checkinTime;
    }

    public Date getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(Date checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", apartmentResidentId=").append(apartmentResidentId);
        sb.append(", apartmentRoomId=").append(apartmentRoomId);
        sb.append(", apartmentResidentReservationId=").append(apartmentResidentReservationId);
        sb.append(", apartmentRentalOrderId=").append(apartmentRentalOrderId);
        sb.append(", status=").append(status);
        sb.append(", checkinTime=").append(checkinTime);
        sb.append(", checkoutTime=").append(checkoutTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}