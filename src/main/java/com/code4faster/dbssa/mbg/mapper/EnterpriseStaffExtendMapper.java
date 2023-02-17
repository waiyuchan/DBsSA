package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.EnterpriseStaff;

public interface EnterpriseStaffExtendMapper extends EnterpriseStaffMapper {

    int queryByUsername(String username);

}
