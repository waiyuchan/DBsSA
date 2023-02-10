package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentRentalPayment;
import java.util.List;

public interface ApartmentRentalPaymentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentRentalPayment record);

    ApartmentRentalPayment selectByPrimaryKey(Integer id);

    List<ApartmentRentalPayment> selectAll();

    int updateByPrimaryKey(ApartmentRentalPayment record);
}