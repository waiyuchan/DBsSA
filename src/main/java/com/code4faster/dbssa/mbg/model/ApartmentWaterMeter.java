package com.code4faster.dbssa.mbg.model;

import java.io.Serializable;

public class ApartmentWaterMeter implements Serializable {
    private Integer id;

    private Integer roomId;

    private Integer waterConsumption;

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

    public Integer getWaterConsumption() {
        return waterConsumption;
    }

    public void setWaterConsumption(Integer waterConsumption) {
        this.waterConsumption = waterConsumption;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roomId=").append(roomId);
        sb.append(", waterConsumption=").append(waterConsumption);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}