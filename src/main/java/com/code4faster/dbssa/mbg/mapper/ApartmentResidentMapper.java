package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentResident;
import java.util.List;

public interface ApartmentResidentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentResident record);

    ApartmentResident selectByPrimaryKey(Integer id);

    List<ApartmentResident> selectAll();

    int updateByPrimaryKey(ApartmentResident record);
}