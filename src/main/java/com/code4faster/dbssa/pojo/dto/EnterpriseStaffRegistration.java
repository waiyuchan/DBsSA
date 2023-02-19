package com.code4faster.dbssa.pojo.dto;

import java.util.Date;

public class EnterpriseStaffRegistration {

    private String username;

    private String password;

    private String name;

    private String idCard;

    private String degree;

    private String college;

    private String email;

    private Integer gender;

    private String phone;

    private String address;

    private Date entryDate;

    public EnterpriseStaffRegistration() {

    }

    public EnterpriseStaffRegistration(String username, String password, String name, String idCard, String degree, String college, String email, Integer gender, String phone, String address, Date entryDate) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.idCard = idCard;
        this.degree = degree;
        this.college = college;
        this.email = email;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                ", idCard='" + idCard + '\'' +
                ", degree='" + degree + '\'' +
                ", college='" + college + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", entryDate=" + entryDate +
                '}';
    }
}
