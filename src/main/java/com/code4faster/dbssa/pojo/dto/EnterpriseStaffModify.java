package com.code4faster.dbssa.pojo.dto;

import java.util.Date;

public class EnterpriseStaffModify {
    private Integer id;

    private String username;

    private String password;

    private String name;

    private Integer gender;

    private String idCard;

    private String degree;

    private String college;

    private String email;

    private String phone;

    private String address;

    private Date entryDate;

    private Date resignationDate;

    public EnterpriseStaffModify(Integer id, String username, String password, String name, Integer gender, String idCard, String degree, String college, String email, String phone, String address, Date entryDate, Date resignationDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.idCard = idCard;
        this.degree = degree;
        this.college = college;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.entryDate = entryDate;
        this.resignationDate = resignationDate;
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

    public Date getResignationDate() {
        return resignationDate;
    }

    public void setResignationDate(Date resignationDate) {
        this.resignationDate = resignationDate;
    }
}
