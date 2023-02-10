package com.code4faster.dbssa.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class ApartmentElectricityMeter implements Serializable {
    private Integer id;

    private Integer roomId;

    private Integer electricityConsumption;

    private Date recordTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getElectricityConsumption() {
        return electricityConsumption;
    }

    public void setElectricityConsumption(Integer electricityConsumption) {
        this.electricityConsumption = electricityConsumption;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roomId=").append(roomId);
        sb.append(", electricityConsumption=").append(electricityConsumption);
        sb.append(", recordTime=").append(recordTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}