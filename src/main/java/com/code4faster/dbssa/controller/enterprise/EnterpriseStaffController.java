package com.code4faster.dbssa.controller.enterprise;

import com.code4faster.dbssa.common.api.ApiResponse;
import com.code4faster.dbssa.common.api.ErrorCode;
import com.code4faster.dbssa.pojo.dto.*;
import com.code4faster.dbssa.service.EnterpriseStaffService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api/operate/enterprise_staff")
public class EnterpriseStaffController {

    @Autowired
    EnterpriseStaffService enterpriseStaffService;

    /**
     * 创建企业员工
     *
     * @param enterpriseStaffRegistration 企业员工注册信息
     */
    @PostMapping
    public ApiResponse createEnterpriseStaff(@RequestBody EnterpriseStaffRegistration enterpriseStaffRegistration) {
        String username = enterpriseStaffRegistration.getUsername();
        boolean isUserExisted = enterpriseStaffService.isUserExisted(username);
        if (isUserExisted) {
            return ApiResponse.failure(ErrorCode.USER_ALREADY_EXISTS);
        }
        boolean success = enterpriseStaffService.createEnterpriseStaff(enterpriseStaffRegistration);
        return (success) ? ApiResponse.success() : ApiResponse.failure(ErrorCode.USER_CREATE_FAILURE);
    }

    /**
     * 获取企业员工列表
     *
     * @param offset 子查询每条时间序列返回数据点的偏移量，默认值是0，代表不限制返回点数量
     * @param limit  子查询每条时间序列返回数据点的最大数目，默认值也是10，代表不偏移返回的数据点
     * @return 企业员工列表数据
     */
    @GetMapping
    public ApiResponse getEnterpriseStaffList(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                              @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        PageInfo<EnterpriseStaffItem> enterpriseStaffItems = enterpriseStaffService.queryEnterpriseStaffList(offset, limit);
        QueryResultSet queryResultSet = new QueryResultSet(enterpriseStaffItems.getSize(), enterpriseStaffItems.getList());
        return ApiResponse.success(queryResultSet);
    }

    /**
     * 查询企业员工信息
     *
     * @param id 企业员工id
     * @return 企业员工信息
     */
    @GetMapping("/{id}")
    public ApiResponse getEnterpriseStaffById(@PathVariable("id") Integer id) {
        EnterpriseStaffDetail enterpriseStaff = enterpriseStaffService.queryEnterpriseStaffById(id);
        return ApiResponse.success(enterpriseStaff);
    }

    /**
     * 更新企业员工信息
     *
     * @param enterpriseStaffModify 企业员工待更新信息
     * @return 无
     */
    @PutMapping
    public ApiResponse updateEnterpriseStaff(@RequestBody EnterpriseStaffModify enterpriseStaffModify) {
        Integer id = enterpriseStaffModify.getId();
        String username = enterpriseStaffModify.getUsername();
        boolean isUsernameChanged = enterpriseStaffService.isUsernameChanged(id, username);
        if (!isUsernameChanged) {
            boolean isUserExisted = enterpriseStaffService.isUserExisted(username);
            if (isUserExisted) {
                return ApiResponse.failure(ErrorCode.USER_ALREADY_EXISTS);
            }
        }
        boolean success = enterpriseStaffService.updateEnterpriseStaff(enterpriseStaffModify);
        return (success) ? ApiResponse.success() : ApiResponse.failure(ErrorCode.RESOURCE_UPDATE_FAILED);
    }

    // @GetMapping("/delete/{id}")
    // public ApiResponse preDeleteEnterpriseStaff(@PathVariable("id") Integer id) {
    //     return null;
    // }
    //
    // @DeleteMapping("/{id}")
    // public ApiResponse deleteEnterpriseStaff(@PathVariable("id") Integer id) {
    //     return null;
    // }
}
