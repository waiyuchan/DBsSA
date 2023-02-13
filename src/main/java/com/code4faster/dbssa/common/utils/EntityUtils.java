package com.code4faster.dbssa.common.utils;

import com.code4faster.dbssa.mbg.model.MovieLib;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EntityUtils {
    // 实体模型工具类

    // 转换Map为带数据的实体类，将键值对集合封装进实体对象属性中
    public <T> T convertMap2EntityClass(Map<String, Object> map, Class<T> tClass) {
        // 由于不确定返回值类型，故定义一个泛型类型 T，作为返回值
        // 本方法有两个参数输入，Map集合 & 实体类，由于输入的实体类未知，故传递Class类作为参数类型，兼容所有的实体类

        try {
            // 拿到实体类的对象
            T t = tClass.newInstance();
            // 拆解map，给对象T的属性赋值
            Set<Map.Entry<String, Object>> entries = map.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                Field field = tClass.getDeclaredField(entry.getKey());
                // 设置修改权限，因为采用的封装private，不修改权限的话，不能修改实体类中的属性值
                field.setAccessible(true);

                // 感谢chatGPT给出的优化建议，
                // 最开始直接使用了 `field.set(t, entry.getValue());`的处理方法
                // 但这会导致map在转换为实体类时，无法解决类型转换冲突的问题
                Object value = entry.getValue();
                if (value.toString().length() != 0) {
                    if (field.getType().equals(String.class)) {
                        field.set(t, value.toString());
                    } else if (field.getType().equals(Integer.class)) {
                        field.set(t, Integer.parseInt(value.toString()));
                    } else if (field.getType().equals(Double.class)) {
                        field.set(t, Double.parseDouble(value.toString()));
                    } else if (field.getType().equals(Date.class)) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            field.set(t, sdf.parse(value.toString()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    field.set(t, null);
                }
            }
            return t;
        } catch (InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            throw new RuntimeException("转换出错了！");
        }
    }

    public void convertMap2EntityClassTest() {
        // 测试方法
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "利刃出鞘");
        map.put("englishName", "Knives Out");
        map.put("directors", "莱恩·约翰逊");
        map.put("writer", "莱恩·约翰逊");
        map.put("actors", "丹尼尔·克雷格  安娜·德·阿玛斯  克里斯·埃文斯  杰米·李·柯蒂斯  迈克尔·珊农");
        map.put("rate", "8.2");
        map.put("style", "剧情 喜剧 悬疑");
        map.put("country", "美国");
        map.put("language", "英语");
        map.put("date", "2019");
        map.put("duration", 130);
        map.put("introduction", "富豪小说家哈兰·斯隆比在自己85岁生日第二天，被发现在自家庄园离奇自杀，遗留了亿万遗产。久负盛名的大侦探布兰科（丹尼尔·克雷格饰）突然被匿名人士雇佣调查此案真相。同时，哈兰的孙子兰森（克里斯·埃文斯饰）也正在秘密调查此案。当布兰科和哈兰·斯隆比家族的其他人对谈时，他发现事情并没有想象中那么简单。  哈兰家族没有表面上那么和睦，每个人都有着不可告人的秘密，每个人都想得到遗产……究竟这起命案是自杀还是他杀？似乎每个人都有嫌疑。随着一位遗产继承人的意外亮相，真相谜底渐渐浮出水面……");
        map.put("doubanId", "30318116");
        map.put("url", "https://movie.douban.com/subject/30318116/");
        map.put("pic", "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2574172427.jpg");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date createDateTime = null;
        try {
            createDateTime = dateFormat.parse("2023-02-13 10:23:54");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        map.put("createTime", createDateTime);

        MovieLib movieLib = convertMap2EntityClass(map, MovieLib.class);
        System.out.println(movieLib);
    }

    public static void main(String[] args) {
        EntityUtils entityUtils = new EntityUtils();
        entityUtils.convertMap2EntityClassTest();
    }
}
