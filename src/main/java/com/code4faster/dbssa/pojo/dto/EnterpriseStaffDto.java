package com.code4faster.dbssa.pojo.dto;

import com.code4faster.dbssa.mbg.model.EnterpriseStaff;

import java.util.Date;

public class EnterpriseStaffDto {

    private Integer id;

    private String username;

    private String name;

    private String email;

    private String phone;

    private String address;

    private Date hiredDate;

    private Integer status;

    private Date resignationDate;

    public EnterpriseStaffDto() {
    }

    public EnterpriseStaffDto(EnterpriseStaff enterpriseStaff) {
        this.id = enterpriseStaff.getId();
        this.username = enterpriseStaff.getUsername();
        this.name = enterpriseStaff.getName();
        this.email = enterpriseStaff.getEmail();
        this.phone = enterpriseStaff.getPhone();
        this.address = enterpriseStaff.getAddress();
        this.hiredDate = enterpriseStaff.getHiredDate();
        this.status = enterpriseStaff.getStatus();
        this.resignationDate = enterpriseStaff.getResignationDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getResignationDate() {
        return resignationDate;
    }

    public void setResignationDate(Date resignationDate) {
        this.resignationDate = resignationDate;
    }
}
