package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentRoomBill;
import java.util.List;

public interface ApartmentRoomBillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentRoomBill record);

    ApartmentRoomBill selectByPrimaryKey(Integer id);

    List<ApartmentRoomBill> selectAll();

    int updateByPrimaryKey(ApartmentRoomBill record);
}