package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.EnterpriseStaff;
import java.util.List;

public interface EnterpriseStaffMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnterpriseStaff record);

    EnterpriseStaff selectByPrimaryKey(Integer id);

    List<EnterpriseStaff> selectAll();

    int updateByPrimaryKey(EnterpriseStaff record);
}