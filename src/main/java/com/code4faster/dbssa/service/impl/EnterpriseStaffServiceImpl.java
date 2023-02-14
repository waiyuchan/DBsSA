package com.code4faster.dbssa.service.impl;

import com.code4faster.dbssa.mbg.mapper.EnterpriseStaffMapper;
import com.code4faster.dbssa.mbg.model.EnterpriseStaff;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffDto;
import com.code4faster.dbssa.service.EnterpriseStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseStaffServiceImpl implements EnterpriseStaffService {

    @Autowired
    EnterpriseStaffMapper enterpriseStaffMapper;

    @Override
    public EnterpriseStaffDto queryEnterpriseStaffById(Integer id) {
        return null;
    }

    @Override
    public List<EnterpriseStaffDto> queryEnterpriseStaffList(Integer offset, Integer limit) {
        return null;
    }

    @Override
    public Integer countAll() {
        return null;
    }

    @Override
    public void createEnterpriseStaff(EnterpriseStaff enterpriseStaff) {

    }

    @Override
    public void updateEnterpriseStaff(EnterpriseStaffDto enterpriseStaffDto) {

    }

    @Override
    public void deleteEnterpriseStaff(Integer id) {

    }
}
