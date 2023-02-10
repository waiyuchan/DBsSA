package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentElectricityRecord;
import java.util.List;

public interface ApartmentElectricityRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentElectricityRecord record);

    ApartmentElectricityRecord selectByPrimaryKey(Integer id);

    List<ApartmentElectricityRecord> selectAll();

    int updateByPrimaryKey(ApartmentElectricityRecord record);
}