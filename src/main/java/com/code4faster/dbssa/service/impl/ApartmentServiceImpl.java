package com.code4faster.dbssa.service.impl;

import com.code4faster.dbssa.mbg.mapper.ApartmentExtendMapper;
import com.code4faster.dbssa.mbg.mapper.ApartmentMapper;
import com.code4faster.dbssa.mbg.mapper.ApartmentRoomTypeExtendMapper;
import com.code4faster.dbssa.mbg.mapper.ApartmentRoomTypeMapper;
import com.code4faster.dbssa.mbg.model.Apartment;
import com.code4faster.dbssa.mbg.model.ApartmentRoomType;
import com.code4faster.dbssa.service.ApartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.checkerframework.checker.units.qual.A;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Resource
    ApartmentMapper apartmentMapper;

    @Resource
    ApartmentExtendMapper apartmentExtendMapper;

    @Resource
    ApartmentRoomTypeMapper apartmentRoomTypeMapper;

    @Resource
    ApartmentRoomTypeExtendMapper apartmentRoomTypeExtendMapper;


    @Override
    public boolean createApartment(Apartment apartment) {
        int row = apartmentMapper.insert(apartment);
        return row > 0;
    }

    @Override
    public boolean isApartmentExists(String apartmentName) {
        int rows = apartmentExtendMapper.queryByApartmentName(apartmentName);
        return rows > 0;
    }

    @Override
    public boolean isApartmentNameChanged(Integer id, String apartmentName) {
        String storageApartmentName = apartmentExtendMapper.queryApartmentNameById(id);
        return storageApartmentName.equals(apartmentName);
    }

    @Override
    public PageInfo<Apartment> queryApartmentList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Apartment> apartmentList = apartmentExtendMapper.queryApartmentList();
        return new PageInfo<>(apartmentList);
    }

    @Override
    public Apartment queryById(Integer id) {
        return apartmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateApartment(Apartment apartment) {
        apartment.setCreateTime(apartmentMapper.selectByPrimaryKey(apartment.getId()).getCreateTime());
        int rows = apartmentMapper.updateByPrimaryKey(apartment);
        return rows > 0;
    }

    @Override
    public boolean isApartmentRoomTypeExists(ApartmentRoomType apartmentRoomType) {
        return apartmentRoomTypeExtendMapper.queryItemExistStatus(apartmentRoomType) > 0;
    }

    @Override
    public boolean createApartmentRoomType(ApartmentRoomType apartmentRoomType) {
        int rows = apartmentRoomTypeMapper.insert(apartmentRoomType);
        return rows > 0;
    }

}
