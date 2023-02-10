package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.Apartment;
import java.util.List;

public interface ApartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Apartment record);

    Apartment selectByPrimaryKey(Integer id);

    List<Apartment> selectAll();

    int updateByPrimaryKey(Apartment record);
}