package com.code4faster.dbssa.controller.apartment;

import com.code4faster.dbssa.mbg.model.Apartment;
import com.code4faster.dbssa.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ApartmentController {


    @RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String createApartment(@RequestBody Apartment apartment) {
        return "";
    }

}
