package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentRentalOrder;
import java.util.List;

public interface ApartmentRentalOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentRentalOrder record);

    ApartmentRentalOrder selectByPrimaryKey(Integer id);

    List<ApartmentRentalOrder> selectAll();

    int updateByPrimaryKey(ApartmentRentalOrder record);
}