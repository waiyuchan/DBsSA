package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentStaff;
import java.util.List;

public interface ApartmentStaffMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentStaff record);

    ApartmentStaff selectByPrimaryKey(Integer id);

    List<ApartmentStaff> selectAll();

    int updateByPrimaryKey(ApartmentStaff record);
}