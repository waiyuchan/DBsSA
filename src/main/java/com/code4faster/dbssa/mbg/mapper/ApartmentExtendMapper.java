package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.Apartment;

import java.util.List;

public interface ApartmentExtendMapper {

    int queryByApartmentName(String apartmentName);

    List<Apartment> queryApartmentList();

    String queryApartmentNameById(Integer id);

}