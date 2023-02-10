package com.code4faster.dbssa.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class ApartmentAssetTagMarked implements Serializable {
    private Integer id;

    private Integer apartmentAssetId;

    private Integer apartmentAssetTagId;

    private Date createTime;

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

    public Integer getApartmentAssetTagId() {
        return apartmentAssetTagId;
    }

    public void setApartmentAssetTagId(Integer apartmentAssetTagId) {
        this.apartmentAssetTagId = apartmentAssetTagId;
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
        sb.append(", apartmentAssetId=").append(apartmentAssetId);
        sb.append(", apartmentAssetTagId=").append(apartmentAssetTagId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}