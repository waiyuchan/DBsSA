package com.code4faster.dbssa.mbg.model;

import java.io.Serializable;

public class ApartmentRoomType implements Serializable {
    private Integer id;

    private String roomTypeName;

    private Integer roomResidentLimit;

    private String roomSize;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName == null ? null : roomTypeName.trim();
    }

    public Integer getRoomResidentLimit() {
        return roomResidentLimit;
    }

    public void setRoomResidentLimit(Integer roomResidentLimit) {
        this.roomResidentLimit = roomResidentLimit;
    }

    public String getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(String roomSize) {
        this.roomSize = roomSize == null ? null : roomSize.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roomTypeName=").append(roomTypeName);
        sb.append(", roomResidentLimit=").append(roomResidentLimit);
        sb.append(", roomSize=").append(roomSize);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}