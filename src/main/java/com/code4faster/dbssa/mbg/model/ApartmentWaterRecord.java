package com.code4faster.dbssa.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class ApartmentWaterRecord implements Serializable {
    private Integer id;

    private Integer waterMeterId;

    private Integer lastReading;

    private Integer latestReading;

    private Integer waterConsumed;

    private Integer waterFee;

    private Integer recordTime;

    private Date settlementDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWaterMeterId() {
        return waterMeterId;
    }

    public void setWaterMeterId(Integer waterMeterId) {
        this.waterMeterId = waterMeterId;
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

    public Integer getWaterConsumed() {
        return waterConsumed;
    }

    public void setWaterConsumed(Integer waterConsumed) {
        this.waterConsumed = waterConsumed;
    }

    public Integer getWaterFee() {
        return waterFee;
    }

    public void setWaterFee(Integer waterFee) {
        this.waterFee = waterFee;
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
        sb.append(", waterMeterId=").append(waterMeterId);
        sb.append(", lastReading=").append(lastReading);
        sb.append(", latestReading=").append(latestReading);
        sb.append(", waterConsumed=").append(waterConsumed);
        sb.append(", waterFee=").append(waterFee);
        sb.append(", recordTime=").append(recordTime);
        sb.append(", settlementDate=").append(settlementDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}