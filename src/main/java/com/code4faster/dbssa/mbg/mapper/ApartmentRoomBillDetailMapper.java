package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentRoomBillDetail;
import java.util.List;

public interface ApartmentRoomBillDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentRoomBillDetail record);

    ApartmentRoomBillDetail selectByPrimaryKey(Integer id);

    List<ApartmentRoomBillDetail> selectAll();

    int updateByPrimaryKey(ApartmentRoomBillDetail record);
}