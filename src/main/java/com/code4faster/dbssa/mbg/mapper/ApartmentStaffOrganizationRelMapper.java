package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentStaffOrganizationRel;
import java.util.List;

public interface ApartmentStaffOrganizationRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentStaffOrganizationRel record);

    ApartmentStaffOrganizationRel selectByPrimaryKey(Integer id);

    List<ApartmentStaffOrganizationRel> selectAll();

    int updateByPrimaryKey(ApartmentStaffOrganizationRel record);
}