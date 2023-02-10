package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentAsset;
import java.util.List;

public interface ApartmentAssetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentAsset record);

    ApartmentAsset selectByPrimaryKey(Integer id);

    List<ApartmentAsset> selectAll();

    int updateByPrimaryKey(ApartmentAsset record);
}