package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.ApartmentResidentReservation;
import java.util.List;

public interface ApartmentResidentReservationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApartmentResidentReservation record);

    ApartmentResidentReservation selectByPrimaryKey(Integer id);

    List<ApartmentResidentReservation> selectAll();

    int updateByPrimaryKey(ApartmentResidentReservation record);
}