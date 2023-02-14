package com.code4faster.dbssa.service;

import com.code4faster.dbssa.mbg.model.EnterpriseStaff;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffDto;

import java.util.List;

public interface EnterpriseStaffService {

    EnterpriseStaffDto queryEnterpriseStaffById(Integer id);

    List<EnterpriseStaffDto> queryEnterpriseStaffList(Integer offset, Integer limit);

    Integer countAll();

    void createEnterpriseStaff(EnterpriseStaff enterpriseStaff);

    void updateEnterpriseStaff(EnterpriseStaffDto enterpriseStaffDto);

    void deleteEnterpriseStaff(Integer id);

}