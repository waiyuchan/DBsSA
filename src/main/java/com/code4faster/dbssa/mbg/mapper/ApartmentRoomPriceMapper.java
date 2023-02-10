package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentRoomPrice;
import java.util.List;

public interface ApartmentRoomPriceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentRoomPrice record);

    ApartmentRoomPrice selectByPrimaryKey(Integer id);

    List<ApartmentRoomPrice> selectAll();

    int updateByPrimaryKey(ApartmentRoomPrice record);
}