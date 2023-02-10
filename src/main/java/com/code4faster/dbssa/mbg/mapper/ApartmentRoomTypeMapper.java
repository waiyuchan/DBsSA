package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentRoomType;
import java.util.List;

public interface ApartmentRoomTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentRoomType record);

    ApartmentRoomType selectByPrimaryKey(Integer id);

    List<ApartmentRoomType> selectAll();

    int updateByPrimaryKey(ApartmentRoomType record);
}