package com.code4faster.dbssa.common.utils;

import com.code4faster.dbssa.mbg.model.Apartment;
import com.code4faster.dbssa.mbg.model.EnterpriseStaff;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffRegistration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;

public class ModelClassUtils {

    /**
     * 将Bean的属性值组装为json字符串返回，目的是为了快速构建接口测试的用例
     *
     * @param object JavaBean，实体类
     * @return `{"Property":"PropertyValue"}` 格式的JSON字符串
     */
    public static String Bean2JsonString(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 从原对象复制相同属性的值到目标对象，由于目标对象未知，故定义一个泛型进行处理
     *
     * @param sourceObject 源对象
     * @param targetObject 目标对象
     * @param <T>          目标对象的泛型定义
     * @return 包含源对象相同属性值的目标对象
     */
    public static <T> T copyValueOfSameProperties(Object sourceObject, Class<T> targetObject) {
        if (sourceObject == null) {
            return null;
        }
        T t = null;
        try {
            t = targetObject.newInstance();
            BeanUtils.copyProperties(sourceObject, t); // 此处采用Spring自带的BeanUtils的属性复制方法
            return t;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static void main(String[] args) {
        // String s = ModelClassUtils.Bean2JsonString(new EnterpriseStaffRegistration());
        // System.out.println(s);
        // EnterpriseStaff enterpriseStaff = new EnterpriseStaff();
        // enterpriseStaff.setAddress("123123");
        // EnterpriseStaffRegistration enterpriseStaffRegistration = ModelClassUtils.copyValueOfSameProperties(enterpriseStaff, EnterpriseStaffRegistration.class);
        // System.out.println(enterpriseStaffRegistration.toString());
        String s = ModelClassUtils.Bean2JsonString(new Apartment());
        System.out.println(s);
    }
}
