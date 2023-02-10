package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentRoomResidentOwnershipRel;
import java.util.List;

public interface ApartmentRoomResidentOwnershipRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentRoomResidentOwnershipRel record);

    ApartmentRoomResidentOwnershipRel selectByPrimaryKey(Integer id);

    List<ApartmentRoomResidentOwnershipRel> selectAll();

    int updateByPrimaryKey(ApartmentRoomResidentOwnershipRel record);
}