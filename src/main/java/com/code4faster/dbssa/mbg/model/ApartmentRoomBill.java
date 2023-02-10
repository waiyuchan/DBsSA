package com.code4faster.dbssa.mbg.model;

import java.io.Serializable;

public class ApartmentRoomBill implements Serializable {
    private Integer id;

    private Integer apartmentRoomId;

    private Integer billPeriod;

    private Integer billDate;

    private Integer billAmount;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApartmentRoomId() {
        return apartmentRoomId;
    }

    public void setApartmentRoomId(Integer apartmentRoomId) {
        this.apartmentRoomId = apartmentRoomId;
    }

    public Integer getBillPeriod() {
        return billPeriod;
    }

    public void setBillPeriod(Integer billPeriod) {
        this.billPeriod = billPeriod;
    }

    public Integer getBillDate() {
        return billDate;
    }

    public void setBillDate(Integer billDate) {
        this.billDate = billDate;
    }

    public Integer getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Integer billAmount) {
        this.billAmount = billAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", apartmentRoomId=").append(apartmentRoomId);
        sb.append(", billPeriod=").append(billPeriod);
        sb.append(", billDate=").append(billDate);
        sb.append(", billAmount=").append(billAmount);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}