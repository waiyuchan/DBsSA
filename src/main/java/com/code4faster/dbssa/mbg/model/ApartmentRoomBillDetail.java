package com.code4faster.dbssa.mbg.model;

import java.io.Serializable;

public class ApartmentRoomBillDetail implements Serializable {
    private Integer id;

    private Integer billId;

    private String itemName;

    private Integer itemAmount;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Integer getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(Integer itemAmount) {
        this.itemAmount = itemAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", billId=").append(billId);
        sb.append(", itemName=").append(itemName);
        sb.append(", itemAmount=").append(itemAmount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}