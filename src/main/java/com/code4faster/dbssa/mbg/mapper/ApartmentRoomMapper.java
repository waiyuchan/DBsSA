package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentRoom;
import java.util.List;

public interface ApartmentRoomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentRoom record);

    ApartmentRoom selectByPrimaryKey(Integer id);

    List<ApartmentRoom> selectAll();

    int updateByPrimaryKey(ApartmentRoom record);
}