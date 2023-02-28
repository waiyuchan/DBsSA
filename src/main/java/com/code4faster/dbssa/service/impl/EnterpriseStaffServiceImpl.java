package com.code4faster.dbssa.service.impl;

import com.code4faster.dbssa.common.utils.ModelClassUtils;
import com.code4faster.dbssa.mbg.mapper.EnterpriseStaffExtendMapper;
import com.code4faster.dbssa.mbg.mapper.EnterpriseStaffMapper;
import com.code4faster.dbssa.mbg.model.EnterpriseStaff;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffDetail;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffItem;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffModify;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffRegistration;
import com.code4faster.dbssa.service.EnterpriseStaffService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnterpriseStaffServiceImpl implements EnterpriseStaffService {

    protected Integer DEFAULT_INITIAL_VALUE = 0;
    protected String ENTERPRISE_MAIL_SUFFIX = "@code4faster";

    @Resource
    EnterpriseStaffMapper enterpriseStaffMapper;

    @Resource
    EnterpriseStaffExtendMapper enterpriseStaffExtendMapper;

    @Override
    public EnterpriseStaffDetail getEnterpriseStaffById(Integer id) {
        EnterpriseStaff enterpriseStaff = enterpriseStaffMapper.selectByPrimaryKey(id);
        return ModelClassUtils.copyValueOfSameProperties(enterpriseStaff, EnterpriseStaffDetail.class);
    }

    @Override
    public PageInfo<EnterpriseStaffItem> listEnterpriseStaffs(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<EnterpriseStaffItem> enterpriseStaffList = enterpriseStaffExtendMapper.queryStaffList();
        return new PageInfo<>(enterpriseStaffList);
    }

    @Override
    public boolean isUserExisted(String username) {
        return enterpriseStaffExtendMapper.queryByUsername(username) > 0;
    }

    @Override
    public boolean isUserExisted(Integer id) {
        return enterpriseStaffMapper.selectByPrimaryKey(id).getId() != null;
    }

    @Override
    public boolean isUsernameChanged(Integer id, String username) {
        String storageUsername = enterpriseStaffExtendMapper.queryUsernameById(id);
        return storageUsername.equals(username);
    }

    @Override
    public boolean save(EnterpriseStaffRegistration enterpriseStaffRegistration) {
        EnterpriseStaff enterpriseStaff = ModelClassUtils.copyValueOfSameProperties(enterpriseStaffRegistration, EnterpriseStaff.class);
        String entMail = enterpriseStaff.getUsername() + ENTERPRISE_MAIL_SUFFIX;
        enterpriseStaff.setId(DEFAULT_INITIAL_VALUE);
        enterpriseStaff.setStatus(DEFAULT_INITIAL_VALUE);
        enterpriseStaff.setEntMail(entMail);
        enterpriseStaff.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
        int row = enterpriseStaffMapper.insert(enterpriseStaff);
        return row > 0;
    }

    @Override
    public boolean updateEnterpriseStaff(EnterpriseStaffModify enterpriseStaffModify) {
        int rows = enterpriseStaffExtendMapper.updateStaffInfo(enterpriseStaffModify);
        return rows > 0;
    }


    // @Override
    // public boolean deleteEnterpriseStaff(Integer id) {
    //     // int rows = enterpriseStaffMapper.deleteByPrimaryKey(id);
    //     // return rows > 0;
    //     return false;
    // }
}
