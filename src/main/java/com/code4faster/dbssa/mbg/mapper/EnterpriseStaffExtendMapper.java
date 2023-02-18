package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.pojo.dto.EnterpriseStaffItem;

import java.util.List;

public interface EnterpriseStaffExtendMapper extends EnterpriseStaffMapper {

    int queryByUsername(String username);

    List<EnterpriseStaffItem> queryStaffList();

}
