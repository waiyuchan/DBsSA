package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentElectricityMeter;
import java.util.List;

public interface ApartmentElectricityMeterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentElectricityMeter record);

    ApartmentElectricityMeter selectByPrimaryKey(Integer id);

    List<ApartmentElectricityMeter> selectAll();

    int updateByPrimaryKey(ApartmentElectricityMeter record);
}