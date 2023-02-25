package com.code4faster.dbssa.service;

import com.code4faster.dbssa.mbg.model.Apartment;
import com.code4faster.dbssa.mbg.model.ApartmentRoomType;
import com.github.pagehelper.PageInfo;

public interface ApartmentService {

    boolean createApartment(Apartment apartment);

    boolean isApartmentExists(String apartmentName);

    boolean isApartmentNameChanged(Integer id, String apartmentName);

    PageInfo<Apartment> queryApartmentList(Integer offset, Integer limit);

    Apartment queryById(Integer id);

    boolean updateApartment(Apartment apartment);

    boolean isApartmentRoomTypeExists(ApartmentRoomType apartmentRoomType);

    boolean createApartmentRoomType(ApartmentRoomType apartmentRoomType);


}
