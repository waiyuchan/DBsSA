package com.code4faster.dbssa.controller.apartment;

import com.code4faster.dbssa.common.api.ApiResponse;
import com.code4faster.dbssa.common.api.ErrorCode;
import com.code4faster.dbssa.mbg.model.Apartment;
import com.code4faster.dbssa.mbg.model.ApartmentRoomPrice;
import com.code4faster.dbssa.mbg.model.ApartmentRoomType;
import com.code4faster.dbssa.pojo.dto.QueryResultSet;
import com.code4faster.dbssa.service.ApartmentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api/admin/apartment")
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
    public ApiResponse updateApartmentInfo(@RequestBody Apartment apartment) {
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

    /**
     * 创建新房型
     *
     * @param apartmentRoomType 房型数据
     * @return 创建结果
     */
    @RequestMapping(path = "/room_type", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ApiResponse createApartmentRoomType(@RequestBody ApartmentRoomType apartmentRoomType) {
        boolean apartmentRoomTypeExistStatus = apartmentService.isApartmentRoomTypeExists(apartmentRoomType);
        if (apartmentRoomTypeExistStatus) {
            return ApiResponse.failure(ErrorCode.RESOURCE_ALREADY_EXISTS);
        }
        boolean success = apartmentService.createApartmentRoomType(apartmentRoomType);
        return (success) ? ApiResponse.success() : ApiResponse.failure(ErrorCode.RESOURCE_UPDATE_FAILED);
    }

    /**
     * 公寓房型绑定，并制定价格
     *
     * @param apartmentRoomPrice 数据内容包含房型id、公寓id、价格
     * @return 定价结果
     */
    @RequestMapping(path = "/room_type/price", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ApiResponse bindRoomTypeToApartmentAndDefindPrice(@RequestBody ApartmentRoomPrice apartmentRoomPrice) {
        // TODO: 接口需要实现绑定方法，并在完成绑定后返回完整的 `公寓->房型->价格` 信息
        return null;
    }


    /**
     * 获取某公寓的房型列表（包含价格信息）
     *
     * @param apartmentId 公寓id
     * @param offset      子查询每条时间序列返回数据点的偏移量，默认值是0，代表不限制返回点数量
     * @param limit       子查询每条时间序列返回数据点的最大数目，默认值也是10，代表不偏移返回的数据点
     * @return 某公寓的房型列表
     */
    @RequestMapping(path = "/room_type/{apartment_id}", method = RequestMethod.GET)
    public ApiResponse getApartmentRoomTypeList(@PathVariable("apartment_id") Integer apartmentId,
                                                @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                                @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        // TODO: 需要从关系表中组合查询出公寓的房型列表
        return null;
    }

}
