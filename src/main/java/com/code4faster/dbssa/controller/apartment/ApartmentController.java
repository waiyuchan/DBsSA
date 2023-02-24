package com.code4faster.dbssa.controller.apartment;

import com.code4faster.dbssa.common.api.ApiResponse;
import com.code4faster.dbssa.common.api.ErrorCode;
import com.code4faster.dbssa.mbg.model.Apartment;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffDetail;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffItem;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffModify;
import com.code4faster.dbssa.pojo.dto.QueryResultSet;
import com.code4faster.dbssa.service.ApartmentService;
import com.github.pagehelper.PageInfo;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api/apartment")
public class ApartmentController {

    @Autowired
    ApartmentService apartmentService;

    /**
     * 创建公寓
     *
     * @param apartment 公寓信息
     * @return 创建结果
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ApiResponse createApartment(@RequestBody Apartment apartment) {
        String apartmentName = apartment.getApartmentName();
        boolean isApartmentExisted = apartmentService.isApartmentExists(apartmentName);
        System.out.println(isApartmentExisted);
        if (isApartmentExisted) {
            return ApiResponse.failure(ErrorCode.RESOURCE_ALREADY_EXISTS);
        }
        boolean success = apartmentService.createApartment(apartment);
        return (success) ? ApiResponse.success() : ApiResponse.failure(ErrorCode.RESOURCE_CREATE_FAILED);
    }

    /**
     * 获取公寓列表
     *
     * @param offset 子查询每条时间序列返回数据点的偏移量，默认值是0，代表不限制返回点数量
     * @param limit  子查询每条时间序列返回数据点的最大数目，默认值也是10，代表不偏移返回的数据点
     * @return 公寓列表数据
     */
    @GetMapping
    public ApiResponse getApartmentList(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                        @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        PageInfo<Apartment> apartmentPageInfo = apartmentService.queryApartmentList(offset, limit);
        QueryResultSet queryResultSet = new QueryResultSet(apartmentPageInfo.getSize(), apartmentPageInfo.getList());
        return ApiResponse.success(queryResultSet);
    }

    /**
     * 查询某一栋公寓的信息
     *
     * @param id 公寓id
     * @return 公寓信息
     */
    @GetMapping("/{id}")
    public ApiResponse getApartmentById(@PathVariable("id") Integer id) {
        Apartment apartment = apartmentService.queryById(id);
        System.out.println(apartment);
        if (apartment == null) {
            return ApiResponse.failure(ErrorCode.RESOURCE_NOT_FOUND);
        }
        return ApiResponse.success(apartment);
    }

    /**
     * 更新公寓楼信息
     *
     * @param apartment 公寓待更新信息
     * @return 无
     */
    @PutMapping
    public ApiResponse updateEnterpriseStaff(@RequestBody Apartment apartment) {
        Integer id = apartment.getId();
        String apartmentName = apartment.getApartmentName();
        boolean isApartmentNameChanged = apartmentService.isApartmentNameChanged(id, apartmentName);
        if (!isApartmentNameChanged) {
            boolean isApartmentExisted = apartmentService.isApartmentExists(apartmentName);
            if (isApartmentExisted) {
                return ApiResponse.failure(ErrorCode.RESOURCE_ALREADY_EXISTS);
            }
        }
        boolean success = apartmentService.updateApartment(apartment);
        return (success) ? ApiResponse.success() : ApiResponse.failure(ErrorCode.RESOURCE_UPDATE_FAILED);
    }
}
