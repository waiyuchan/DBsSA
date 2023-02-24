package com.code4faster.dbssa.controller.apartment;

import com.code4faster.dbssa.common.api.ApiResponse;
import com.code4faster.dbssa.common.api.ErrorCode;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffRegistration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/apartment")
public class ApartmentStaffController {

    @PostMapping
    public ApiResponse createEnterpriseStaff(@RequestBody EnterpriseStaffRegistration enterpriseStaffRegistration) {
        boolean success = true;
        return (success) ? ApiResponse.success() : ApiResponse.failure(ErrorCode.USER_CREATE_FAILURE);
    }

}
