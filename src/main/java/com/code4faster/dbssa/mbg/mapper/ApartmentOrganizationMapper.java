package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentOrganization;
import java.util.List;

public interface ApartmentOrganizationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentOrganization record);

    ApartmentOrganization selectByPrimaryKey(Integer id);

    List<ApartmentOrganization> selectAll();

    int updateByPrimaryKey(ApartmentOrganization record);
}