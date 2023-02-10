package com.code4faster.dbssa.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class ApartmentStaffOrganizationRel implements Serializable {
    private Integer id;

    private Integer apartmentStaffId;

    private Integer orgId;

    private Date joinTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApartmentStaffId() {
        return apartmentStaffId;
    }

    public void setApartmentStaffId(Integer apartmentStaffId) {
        this.apartmentStaffId = apartmentStaffId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
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
        sb.append(", apartmentStaffId=").append(apartmentStaffId);
        sb.append(", orgId=").append(orgId);
        sb.append(", joinTime=").append(joinTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}