package com.code4faster.dbssa.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class ApartmentElectricityRecord implements Serializable {
    private Integer id;

    private Integer electricityMeterId;

    private Integer lastReading;

    private Integer latestReading;

    private Integer electricityConsumed;

    private Integer electricityFee;

    private Integer recordTime;

    private Date settlementDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getElectricityMeterId() {
        return electricityMeterId;
    }

    public void setElectricityMeterId(Integer electricityMeterId) {
        this.electricityMeterId = electricityMeterId;
    }

    public Integer getLastReading() {
        return lastReading;
    }

    public void setLastReading(Integer lastReading) {
        this.lastReading = lastReading;
    }

    public Integer getLatestReading() {
        return latestReading;
    }

    public void setLatestReading(Integer latestReading) {
        this.latestReading = latestReading;
    }

    public Integer getElectricityConsumed() {
        return electricityConsumed;
    }

    public void setElectricityConsumed(Integer electricityConsumed) {
        this.electricityConsumed = electricityConsumed;
    }

    public Integer getElectricityFee() {
        return electricityFee;
    }

    public void setElectricityFee(Integer electricityFee) {
        this.electricityFee = electricityFee;
    }

    public Integer getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Integer recordTime) {
        this.recordTime = recordTime;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", electricityMeterId=").append(electricityMeterId);
        sb.append(", lastReading=").append(lastReading);
        sb.append(", latestReading=").append(latestReading);
        sb.append(", electricityConsumed=").append(electricityConsumed);
        sb.append(", electricityFee=").append(electricityFee);
        sb.append(", recordTime=").append(recordTime);
        sb.append(", settlementDate=").append(settlementDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}