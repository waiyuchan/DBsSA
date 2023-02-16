package com.code4faster.dbssa.service;

import com.code4faster.dbssa.mbg.model.EnterpriseStaff;
// import com.code4faster.dbssa.pojo.dto.EnterpriseStaffDto;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffRegistration;

import java.util.List;

public interface EnterpriseStaffService {

    // EnterpriseStaffDto queryEnterpriseStaffById(Integer id);
    //
    // List<EnterpriseStaffDto> queryEnterpriseStaffList(Integer offset, Integer limit);

    // Integer countAll();

    boolean createEnterpriseStaff(EnterpriseStaffRegistration enterpriseStaffRegistration);

    // boolean updateEnterpriseStaff(EnterpriseStaff enterpriseStaffDto);

    // boolean deleteEnterpriseStaff(Integer id);

}