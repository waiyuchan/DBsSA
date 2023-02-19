package com.code4faster.dbssa.pojo.dto;

import java.util.Date;

public class EnterpriseStaffRegistration {

    private String username;

    private String password;

    private String name;

    private Integer gender;

    private String phone;

    private String address;

    private Date entryDate;

    public EnterpriseStaffRegistration() {

    }

    public EnterpriseStaffRegistration(String username, String password, String name, Integer gender, String phone, String address, Date entryDate, Date resignationDate) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.entryDate = entryDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        return "EnterpriseStaffRegistration{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", entryDate=" + entryDate +
                '}';
    }
}
