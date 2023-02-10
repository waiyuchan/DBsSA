package com.code4faster.dbssa.mbg.model;

import java.io.Serializable;

public class ApartmentAssetAllocationRel implements Serializable {
    private Integer id;

    private Integer apartmentAssetId;

    private Integer apartmentRoomId;

    private Integer createTime;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApartmentAssetId() {
        return apartmentAssetId;
    }

    public void setApartmentAssetId(Integer apartmentAssetId) {
        this.apartmentAssetId = apartmentAssetId;
    }

    public Integer getApartmentRoomId() {
        return apartmentRoomId;
    }

    public void setApartmentRoomId(Integer apartmentRoomId) {
        this.apartmentRoomId = apartmentRoomId;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
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
        sb.append(", apartmentAssetId=").append(apartmentAssetId);
        sb.append(", apartmentRoomId=").append(apartmentRoomId);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}