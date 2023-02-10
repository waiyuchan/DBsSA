package com.code4faster.dbssa.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class ApartmentStaff implements Serializable {
    private Integer id;

    private Integer apartmentId;

    private Integer enterpriseStaffId;

    private Integer staffRoleId;

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

    public Integer getEnterpriseStaffId() {
        return enterpriseStaffId;
    }

    public void setEnterpriseStaffId(Integer enterpriseStaffId) {
        this.enterpriseStaffId = enterpriseStaffId;
    }

    public Integer getStaffRoleId() {
        return staffRoleId;
    }

    public void setStaffRoleId(Integer staffRoleId) {
        this.staffRoleId = staffRoleId;
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
        sb.append(", enterpriseStaffId=").append(enterpriseStaffId);
        sb.append(", staffRoleId=").append(staffRoleId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}