package com.code4faster.dbssa.service.impl;

import com.code4faster.dbssa.common.utils.ModelClassUtils;
import com.code4faster.dbssa.mbg.mapper.EnterpriseStaffMapper;
import com.code4faster.dbssa.mbg.model.EnterpriseStaff;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffRegistration;
import com.code4faster.dbssa.service.EnterpriseStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnterpriseStaffServiceImpl implements EnterpriseStaffService {

    @Resource
    EnterpriseStaffMapper enterpriseStaffMapper;

    // @Override
    // public EnterpriseStaffDto queryEnterpriseStaffById(Integer id) {
    //     // EnterpriseStaff enterpriseStaff = enterpriseStaffMapper.selectByPrimaryKey(id);
    //     return null;
    // }
    //
    //
    // @Override
    // public List<EnterpriseStaffDto> queryEnterpriseStaffList(Integer offset, Integer limit) {
    //     return null;
    // }

    @Override
    public Integer countAll() {
        return null;
    }

    @Override
    public boolean createEnterpriseStaff(EnterpriseStaffRegistration enterpriseStaffRegistration) {
        EnterpriseStaff enterpriseStaff = ModelClassUtils.copyValueOfSameProperties(enterpriseStaffRegistration, EnterpriseStaff.class);
        System.out.println(enterpriseStaff);
        int row = enterpriseStaffMapper.insert(enterpriseStaff);
        return row > 0;
    }

    @Override
    public boolean updateEnterpriseStaff(EnterpriseStaff enterpriseStaffDto) {
        EnterpriseStaff enterpriseStaff = new EnterpriseStaff();
        // TODO: 需要添加一个将 EnterpriseStaff 转换为 EnterpriseStaffDto 的通用方法
        // int rows = enterpriseStaffMapper.updateByPrimaryKey(enterpriseStaff);
        // return rows > 0;
        return false;
    }


    @Override
    public boolean deleteEnterpriseStaff(Integer id) {
        // int rows = enterpriseStaffMapper.deleteByPrimaryKey(id);
        // return rows > 0;
        return false;
    }
}
