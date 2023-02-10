package com.code4faster.dbssa.mbg.model;

import java.io.Serializable;

public class ApartmentRoomPrice implements Serializable {
    private Integer id;

    private Integer apartmentId;

    private Integer apartmentRoomTypeId;

    private Integer price;

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

    public Integer getApartmentRoomTypeId() {
        return apartmentRoomTypeId;
    }

    public void setApartmentRoomTypeId(Integer apartmentRoomTypeId) {
        this.apartmentRoomTypeId = apartmentRoomTypeId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", apartmentId=").append(apartmentId);
        sb.append(", apartmentRoomTypeId=").append(apartmentRoomTypeId);
        sb.append(", price=").append(price);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}