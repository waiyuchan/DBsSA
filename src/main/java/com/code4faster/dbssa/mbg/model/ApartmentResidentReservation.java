package com.code4faster.dbssa.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class ApartmentResidentReservation implements Serializable {
    private Integer id;

    private Integer apartmentRoomId;

    private Integer apartmentResidentId;

    private Integer status;

    private Date createTime;

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

    public Integer getApartmentResidentId() {
        return apartmentResidentId;
    }

    public void setApartmentResidentId(Integer apartmentResidentId) {
        this.apartmentResidentId = apartmentResidentId;
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
        sb.append(", apartmentRoomId=").append(apartmentRoomId);
        sb.append(", apartmentResidentId=").append(apartmentResidentId);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}