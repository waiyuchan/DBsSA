package com.code4faster.dbssa.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class Apartment implements Serializable {
    private Integer id;

    private String apartmentName;

    private String address;

    private String officialPhone;

    private Integer floorNumber;

    private Integer numberOfRooms;

    private Integer numberOfBedrooms;

    private Integer numberOfBathrooms;

    private Integer numberOfPublicRooms;

    private String floorSpace;

    private Integer maximumRent;

    private Date createDate;

    private Date startDate;

    private Integer status;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName == null ? null : apartmentName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getOfficialPhone() {
        return officialPhone;
    }

    public void setOfficialPhone(String officialPhone) {
        this.officialPhone = officialPhone == null ? null : officialPhone.trim();
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(Integer numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public Integer getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(Integer numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public Integer getNumberOfPublicRooms() {
        return numberOfPublicRooms;
    }

    public void setNumberOfPublicRooms(Integer numberOfPublicRooms) {
        this.numberOfPublicRooms = numberOfPublicRooms;
    }

    public String getFloorSpace() {
        return floorSpace;
    }

    public void setFloorSpace(String floorSpace) {
        this.floorSpace = floorSpace == null ? null : floorSpace.trim();
    }

    public Integer getMaximumRent() {
        return maximumRent;
    }

    public void setMaximumRent(Integer maximumRent) {
        this.maximumRent = maximumRent;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", apartmentName=").append(apartmentName);
        sb.append(", address=").append(address);
        sb.append(", officialPhone=").append(officialPhone);
        sb.append(", floorNumber=").append(floorNumber);
        sb.append(", numberOfRooms=").append(numberOfRooms);
        sb.append(", numberOfBedrooms=").append(numberOfBedrooms);
        sb.append(", numberOfBathrooms=").append(numberOfBathrooms);
        sb.append(", numberOfPublicRooms=").append(numberOfPublicRooms);
        sb.append(", floorSpace=").append(floorSpace);
        sb.append(", maximumRent=").append(maximumRent);
        sb.append(", createDate=").append(createDate);
        sb.append(", startDate=").append(startDate);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}