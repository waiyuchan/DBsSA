package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentStaffRole;
import java.util.List;

public interface ApartmentStaffRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentStaffRole record);

    ApartmentStaffRole selectByPrimaryKey(Integer id);

    List<ApartmentStaffRole> selectAll();

    int updateByPrimaryKey(ApartmentStaffRole record);
}