package com.code4faster.dbssa.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class ApartmentRentalPayment implements Serializable {
    private Integer id;

    private Integer orderId;

    private Integer totalPaymentPeriod;

    private Integer currentInstallmentPeriod;

    private Integer currentInstallmentAmount;

    private Date paymentDate;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getTotalPaymentPeriod() {
        return totalPaymentPeriod;
    }

    public void setTotalPaymentPeriod(Integer totalPaymentPeriod) {
        this.totalPaymentPeriod = totalPaymentPeriod;
    }

    public Integer getCurrentInstallmentPeriod() {
        return currentInstallmentPeriod;
    }

    public void setCurrentInstallmentPeriod(Integer currentInstallmentPeriod) {
        this.currentInstallmentPeriod = currentInstallmentPeriod;
    }

    public Integer getCurrentInstallmentAmount() {
        return currentInstallmentAmount;
    }

    public void setCurrentInstallmentAmount(Integer currentInstallmentAmount) {
        this.currentInstallmentAmount = currentInstallmentAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
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
        sb.append(", orderId=").append(orderId);
        sb.append(", totalPaymentPeriod=").append(totalPaymentPeriod);
        sb.append(", currentInstallmentPeriod=").append(currentInstallmentPeriod);
        sb.append(", currentInstallmentAmount=").append(currentInstallmentAmount);
        sb.append(", paymentDate=").append(paymentDate);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}