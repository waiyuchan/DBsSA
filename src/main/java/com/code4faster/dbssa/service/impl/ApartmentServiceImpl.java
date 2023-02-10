package com.code4faster.dbssa.service.impl;

import com.code4faster.dbssa.mbg.mapper.ApartmentMapper;
import com.code4faster.dbssa.mbg.model.Apartment;
import com.code4faster.dbssa.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    private ApartmentMapper apartmentMapper;

    @Override
    public int create(Apartment apartment) {
        return apartmentMapper.insert(apartment);
    }

}
