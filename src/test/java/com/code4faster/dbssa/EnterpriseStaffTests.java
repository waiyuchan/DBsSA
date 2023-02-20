package com.code4faster.dbssa;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.apifan.common.random.RandomSource;
import com.code4faster.dbssa.common.utils.TestCaseGeneratorUtils;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffRegistration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EnterpriseStaffTests {

    @LocalServerPort
    private int port;

    private static TestRestTemplate restTemplate;
    private static HttpHeaders headers;
    private static String baseUrl;

    @BeforeAll
    static void setup() {
        restTemplate = new TestRestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        baseUrl = "http://localhost:";
    }

    @Test
    public void caseCreateEnterpriseStaff() {
        // 创建用户
        String createUserUrl = baseUrl + port + "/api/enterprise_staff";
        Map<String, Object> createUserRequestBody = new HashMap<>();
        // 构建新的企业员工信息
        int gender = TestCaseGeneratorUtils.getNum(0, 1);
        String name = TestCaseGeneratorUtils.generateName(gender);
        String username = TestCaseGeneratorUtils.generateUsername(name);
        String password = TestCaseGeneratorUtils.generatePassword();
        String phoneNum = TestCaseGeneratorUtils.generateTelephoneNum();
        String email = RandomSource.internetSource().randomEmail(15);
        String idCard = TestCaseGeneratorUtils.generateIdCard(gender);
        String degree = TestCaseGeneratorUtils.generateDegree();
        String college = TestCaseGeneratorUtils.generateCollege();
        String address = TestCaseGeneratorUtils.generateAddress();
        String entryDate = TestCaseGeneratorUtils.generateEntryDate();

        createUserRequestBody.put("name", name);
        createUserRequestBody.put("username", username);
        createUserRequestBody.put("password", password);
        createUserRequestBody.put("gender", gender);
        createUserRequestBody.put("phone", phoneNum);
        createUserRequestBody.put("email", email);
        createUserRequestBody.put("idCard", idCard);
        createUserRequestBody.put("degree", degree);
        createUserRequestBody.put("college", college);
        createUserRequestBody.put("address", address);
        createUserRequestBody.put("entryDate", entryDate);

        HttpEntity<Map<String, Object>> createUserRequest = new HttpEntity<>(createUserRequestBody, headers);
        Map<String, Object> createUserResponse = restTemplate.exchange(createUserUrl, HttpMethod.POST, createUserRequest, Map.class).getBody();

        // 验证响应数据是否正确
        assert createUserResponse != null;
        if (createUserResponse.get("errorMsg").toString().equals("10006")) {
            createUserRequestBody.put("username", username + "_0" + Integer.toString(TestCaseGeneratorUtils.getNum(1, 100)));
            HttpEntity<Map<String, Object>> createUserRequestAgain = new HttpEntity<>(createUserRequestBody, headers);
            Map<String, Object> createUserResponseAgain = restTemplate.exchange(createUserUrl, HttpMethod.POST, createUserRequestAgain, Map.class).getBody();
            assertEquals(createUserResponseAgain.get("errorCode"), 0);
            assertEquals(createUserResponseAgain.get("errorMsg"), "请求成功");
        }
        assertEquals(createUserResponse.get("errorCode"), 0);
        assertEquals(createUserResponse.get("errorMsg"), "请求成功");

    }

    @Test
    public void caseGetEnterpriseStaffList() {
        int offset = 0;
        int limit = TestCaseGeneratorUtils.getNum(1, 100);
        String getEnterpriseStaffListUrl = baseUrl + port + "/api/enterprise_staff?offset=" + offset + "&limit=" + limit;
        Map<String, Object> getUserResponse = restTemplate.exchange(getEnterpriseStaffListUrl, HttpMethod.GET, new HttpEntity<>(headers), Map.class).getBody();

        // 验证响应数据是否正确
        assert getUserResponse != null;
        System.out.println(getUserResponse);
        assertEquals(getUserResponse.get("errorCode"), 0);
        assertEquals(getUserResponse.get("errorMsg"), "请求成功");
        Map<String, Object> map = (Map<String, Object>) getUserResponse.get("data");
        assertEquals(map.get("total"), limit);
    }

}
