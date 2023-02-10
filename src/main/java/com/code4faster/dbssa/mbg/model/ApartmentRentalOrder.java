package com.code4faster.dbssa.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class ApartmentRentalOrder implements Serializable {
    private Integer id;

    private Integer apartmentId;

    private String apartmentName;

    private Integer apartmentRoomId;

    private String apartmentRoomNumber;

    private Integer apartmentResidentId;

    private String apartmentResidentUsername;

    private Integer apartmentResidentReservationId;

    private Integer price;

    private Integer payByInstallment;

    private Integer status;

    private Date startDate;

    private Date endDate;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName == null ? null : apartmentName.trim();
    }

    public Integer getApartmentRoomId() {
        return apartmentRoomId;
    }

    public void setApartmentRoomId(Integer apartmentRoomId) {
        this.apartmentRoomId = apartmentRoomId;
    }

    public String getApartmentRoomNumber() {
        return apartmentRoomNumber;
    }

    public void setApartmentRoomNumber(String apartmentRoomNumber) {
        this.apartmentRoomNumber = apartmentRoomNumber == null ? null : apartmentRoomNumber.trim();
    }

    public Integer getApartmentResidentId() {
        return apartmentResidentId;
    }

    public void setApartmentResidentId(Integer apartmentResidentId) {
        this.apartmentResidentId = apartmentResidentId;
    }

    public String getApartmentResidentUsername() {
        return apartmentResidentUsername;
    }

    public void setApartmentResidentUsername(String apartmentResidentUsername) {
        this.apartmentResidentUsername = apartmentResidentUsername == null ? null : apartmentResidentUsername.trim();
    }

    public Integer getApartmentResidentReservationId() {
        return apartmentResidentReservationId;
    }

    public void setApartmentResidentReservationId(Integer apartmentResidentReservationId) {
        this.apartmentResidentReservationId = apartmentResidentReservationId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPayByInstallment() {
        return payByInstallment;
    }

    public void setPayByInstallment(Integer payByInstallment) {
        this.payByInstallment = payByInstallment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", apartmentId=").append(apartmentId);
        sb.append(", apartmentName=").append(apartmentName);
        sb.append(", apartmentRoomId=").append(apartmentRoomId);
        sb.append(", apartmentRoomNumber=").append(apartmentRoomNumber);
        sb.append(", apartmentResidentId=").append(apartmentResidentId);
        sb.append(", apartmentResidentUsername=").append(apartmentResidentUsername);
        sb.append(", apartmentResidentReservationId=").append(apartmentResidentReservationId);
        sb.append(", price=").append(price);
        sb.append(", payByInstallment=").append(payByInstallment);
        sb.append(", status=").append(status);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}