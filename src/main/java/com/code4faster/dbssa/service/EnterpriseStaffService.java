package com.code4faster.dbssa.service;

import com.code4faster.dbssa.pojo.dto.EnterpriseStaffDetail;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffItem;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffModify;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffRegistration;
import com.github.pagehelper.PageInfo;

public interface EnterpriseStaffService {

    EnterpriseStaffDetail getEnterpriseStaffById(Integer id);

    PageInfo<EnterpriseStaffItem> listEnterpriseStaffs(Integer offset, Integer limit);

    boolean isUserExisted(String username);

    boolean isUserExisted(Integer id);

    boolean isUsernameChanged(Integer id, String username);

    boolean save(EnterpriseStaffRegistration enterpriseStaffRegistration);

    boolean updateEnterpriseStaff(EnterpriseStaffModify enterpriseStaffModify);

    // boolean deleteEnterpriseStaff(Integer id);

}