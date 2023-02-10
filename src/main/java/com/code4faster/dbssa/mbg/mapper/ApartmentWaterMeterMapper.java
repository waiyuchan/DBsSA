package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentWaterMeter;
import java.util.List;

public interface ApartmentWaterMeterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentWaterMeter record);

    ApartmentWaterMeter selectByPrimaryKey(Integer id);

    List<ApartmentWaterMeter> selectAll();

    int updateByPrimaryKey(ApartmentWaterMeter record);
}