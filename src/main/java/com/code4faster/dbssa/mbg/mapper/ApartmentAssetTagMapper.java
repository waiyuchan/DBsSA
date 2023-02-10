package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentAssetTag;
import java.util.List;

public interface ApartmentAssetTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentAssetTag record);

    ApartmentAssetTag selectByPrimaryKey(Integer id);

    List<ApartmentAssetTag> selectAll();

    int updateByPrimaryKey(ApartmentAssetTag record);
}