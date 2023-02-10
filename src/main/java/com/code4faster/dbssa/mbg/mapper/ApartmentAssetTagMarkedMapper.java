package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentAssetTagMarked;
import java.util.List;

public interface ApartmentAssetTagMarkedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentAssetTagMarked record);

    ApartmentAssetTagMarked selectByPrimaryKey(Integer id);

    List<ApartmentAssetTagMarked> selectAll();

    int updateByPrimaryKey(ApartmentAssetTagMarked record);
}