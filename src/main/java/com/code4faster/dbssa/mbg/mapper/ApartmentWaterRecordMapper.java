package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentWaterRecord;
import java.util.List;

public interface ApartmentWaterRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentWaterRecord record);

    ApartmentWaterRecord selectByPrimaryKey(Integer id);

    List<ApartmentWaterRecord> selectAll();

    int updateByPrimaryKey(ApartmentWaterRecord record);
}