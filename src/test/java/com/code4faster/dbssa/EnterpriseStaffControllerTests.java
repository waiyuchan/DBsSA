package com.code4faster.dbssa;


import com.apifan.common.random.RandomSource;
import com.code4faster.dbssa.common.utils.TestCaseGeneratorUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Locale;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EnterpriseStaffControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        // 注册新的企业员工
        int gender = TestCaseGeneratorUtils.getNum(0, 1);
        String name = TestCaseGeneratorUtils.generateName(gender);
        System.out.println(name);


        // int gender = 0;
        // String name = TestCaseGeneratorUtils.generateName(0);
        // String username = TestCaseGeneratorUtils.generateUsername(name);
        // System.out.println(username);
        // String username = "testUser";
        // String password = "testPassword";
        //
        // // 构建请求参数
        // MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        // paramMap.add("username", username);
        // paramMap.add("password", password);
        //
        // // 发送 POST 请求
        // MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
        //                 .params(paramMap)
        //                 .accept(MediaType.APPLICATION_JSON_UTF8))
        //         .andExpect(MockMvcResultMatchers.status().isOk())
        //         .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200))
        //         .andExpect(MockMvcResultMatchers.jsonPath("$.data.token").exists())
        //         .andReturn();
        // String responseString = result.getResponse().getContentAsString();
        //
        // // 解析响应数据
        // JSONObject responseObject = JSON.parseObject(responseString);
        // String token = responseObject.getJSONObject("data").getString("token");
        //
        // // 构建带 Token 的 GET 请求
        // MvcResult result2 = mockMvc.perform(MockMvcRequestBuilders.get("/user/info")
        //                 .param("token", token)
        //                 .accept(MediaType.APPLICATION_JSON_UTF8))
        //         .andExpect(MockMvcResultMatchers.status().isOk())
        //         .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200))
        //         .andExpect(MockMvcResultMatchers.jsonPath("$.data.username").value(username))
        //         .andReturn();
        // String responseString2 = result2.getResponse().getContentAsString();
        //
        // // 解析响应数据
        // JSONObject responseObject2 = JSON.parseObject(responseString2);
        // String userInfo = responseObject2.getJSONObject("data").toJSONString();
        //
        // // 构建带 Token 的 POST 请求
        // MvcResult result3 = mockMvc.perform(MockMvcRequestBuilders.post("/user/logout")
        //                 .param("token", token)
        //                 .accept(MediaType.APPLICATION_JSON_UTF8))
        //         .andExpect(MockMvcResultMatchers.status().isOk())
        //         .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200))
        //         .andReturn();
    }

}
