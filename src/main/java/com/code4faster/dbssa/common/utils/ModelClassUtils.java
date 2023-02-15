package com.code4faster.dbssa.common.utils;

import com.code4faster.dbssa.mbg.model.EnterpriseStaff;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffRegistration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;

public class ModelClassUtils {

    public static String Bean2JsonString(Object object) {
        // 将Bean的属性值组装为json字符串返回，目的是为了快速构建接口测试的用例
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T copyValueOfSameProperties(Object sourceObject, Class<T> targetObject) {
        if (sourceObject == null) {
            return null;
        }
        T t = null;
        try {
            t = targetObject.newInstance();
            BeanUtils.copyProperties(sourceObject, t);
            return t;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }


    public static void main(String[] args) {

        String s = ModelClassUtils.Bean2JsonString(new EnterpriseStaffRegistration());
        System.out.println(s);
        EnterpriseStaff enterpriseStaff = new EnterpriseStaff();
        enterpriseStaff.setAddress("123123");
        EnterpriseStaffRegistration enterpriseStaffRegistration = ModelClassUtils.copyValueOfSameProperties(enterpriseStaff, EnterpriseStaffRegistration.class);
        System.out.println(enterpriseStaffRegistration.toString());
    }
}
