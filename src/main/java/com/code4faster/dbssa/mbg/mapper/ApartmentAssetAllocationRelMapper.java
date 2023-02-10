package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentAssetAllocationRel;
import java.util.List;

public interface ApartmentAssetAllocationRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentAssetAllocationRel record);

    ApartmentAssetAllocationRel selectByPrimaryKey(Integer id);

    List<ApartmentAssetAllocationRel> selectAll();

    int updateByPrimaryKey(ApartmentAssetAllocationRel record);
}