package com.code4faster.dbssa.service;

import com.code4faster.dbssa.mbg.model.Apartment;
import com.code4faster.dbssa.mbg.model.ApartmentRoom;
import com.code4faster.dbssa.mbg.model.ApartmentRoomType;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ApartmentService {

    boolean saveApartment(Apartment apartment);

    boolean isApartmentExists(String apartmentName);

    boolean isApartmentNameChanged(Integer id, String apartmentName);

    Apartment getApartmentById(Integer id);

    PageInfo<Apartment> listApartments(Integer offset, Integer limit);

    boolean updateApartment(Apartment apartment);

    boolean isApartmentRoomTypeExists(ApartmentRoomType apartmentRoomType);

    boolean saveApartmentRoomType(ApartmentRoomType apartmentRoomType);

    boolean isApartmentRoomExists(ApartmentRoom apartmentRoom);

    boolean saveApartmentRoom(ApartmentRoom apartmentRoom);

    boolean saveApartmentRoomWithBatchData(List<ApartmentRoom> apartmentRooms);

}
