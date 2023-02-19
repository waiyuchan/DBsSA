package com.code4faster.dbssa.common.utils;

import cn.hutool.extra.pinyin.PinyinUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.apifan.common.random.RandomSource;
import com.apifan.common.random.constant.Province;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCaseGeneratorUtils {

    private static final String[] FIRST_NAMES = {
            "Alexander", "Avery", "Bennett", "Cameron", "Carter", "Christian", "Connor", "Dominic",
            "Ethan", "Gabriel", "Gavin", "Grayson", "Hunter", "Ian", "Isaac", "Jace", "Jackson",
            "Jacob", "Jayden", "Jonah", "Jordan", "Jude", "Julian", "Kai", "Landon", "Levi",
            "Liam", "Lincoln", "Logan", "Lucas", "Maddox", "Mason", "Micah", "Nathan", "Noah",
            "Oliver", "Owen", "Parker", "Quinn", "Ryan", "Samuel", "Sebastian", "Theodore", "Tristan",
            "Tyler", "William", "Wyatt", "Xavier", "Zachary", "Zane"
    };
    private static final String[] LAST_NAMES = {
            "Anderson", "Baker", "Carter", "Davis", "Edwards", "Ford", "Garcia", "Hernandez",
            "Jackson", "Johnson", "King", "Lee", "Lewis", "Martin", "Mitchell", "Moore",
            "Murphy", "Nelson", "Parker", "Perez", "Phillips", "Ramirez", "Reed", "Robinson",
            "Rodriguez", "Sanchez", "Sanders", "Scott", "Smith", "Taylor", "Thomas", "Thompson",
            "Turner", "Walker", "White", "Williams", "Wilson", "Wood", "Wright", "Young"
    };

    private static final Random random = new Random();

    private static final String ENTERPRISE_MAIL_SUFFIX = "code4faster";

    /**
     * 随机生成名字，随机生成中文姓名/英文姓名
     *
     * @param gender 性别
     * @return 姓名
     */
    public static String generateName(int gender) {
        int choice = getNum(0, 1);
        return (choice == 0) ? generateEngName() : generateChnName(gender);
    }

    /**
     * 随机生成英文名
     *
     * @return 英文名
     */
    private static String generateEngName() {
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;
    }

    /**
     * 根据性别随机生成中文名
     *
     * @param gender 性别
     * @return 中文名
     */
    private static String generateChnName(int gender) {
        return (gender == 0) ? RandomSource.personInfoSource().randomMaleChineseName() : RandomSource.personInfoSource().randomFemaleChineseName();
    }

    /**
     * 判断是否是中文姓名
     *
     * @param name 姓名
     * @return 是或否
     */
    public static boolean isChineseName(String name) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(name);
        return m.find();
    }

    /**
     * 根据姓名生成用户名
     *
     * @param name 姓名
     * @return 用户名
     */
    public static String generateUsername(String name) {
        return (isChineseName(name)) ? PinyinUtil.getPinyin(name, "") : name.replace(" ", "_").toLowerCase();
    }

    /**
     * 根据数字区间获取随机数
     *
     * @param start 起始区间
     * @param end   结束区间
     * @return 随机数
     */
    public static int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }

    /**
     * 根据性别随机生成身份证
     *
     * @param gender 性别
     * @return 身份证
     */
    public static String generateIdCard(int gender) {
        LocalDate beginDate = LocalDate.of(1990, 11, 11);
        LocalDate endDate = LocalDate.of(1999, 12, 12);
        List<Province> provinceList = Arrays.asList(Province.values());
        int index = getNum(0, provinceList.size() - 1);
        return (gender == 0)
                ? RandomSource.personInfoSource().randomMaleIdCard(Province.valueOf(provinceList.get(index).toString()), beginDate, endDate)
                : RandomSource.personInfoSource().randomFemaleIdCard(Province.valueOf(provinceList.get(index).toString()), beginDate, endDate);
    }

    /**
     * 根据用户名随机生成企业员工邮箱
     *
     * @param username 用户名
     * @return 企业员工邮箱
     */
    public static String generateEnterpriseMail(String username) {
        return username + ENTERPRISE_MAIL_SUFFIX;
    }

    /**
     * 随机生成手机号码
     *
     * @return 手机号码
     */
    public static String generateTelephoneNum() {
        return RandomSource.personInfoSource().randomChineseMobile();
    }

    /**
     * 随机生成学历
     *
     * @return 学历
     */
    public static String generateDegree() {
        return RandomSource.educationSource().randomDegree();
    }

    /**
     * 随机生成毕业院校
     *
     * @return 毕业院校
     */
    public static String generateCollege() {
        return RandomSource.educationSource().randomCollege();
    }

    /**
     * 随机生成带特殊字符的密码
     *
     * @return 密码
     */
    public static String generatePassword() {
        return RandomSource.personInfoSource().randomStrongPassword(16, true);
    }

    public static String generateAddress() {
        return RandomSource.areaSource().randomAddress();
    }

    public static String generateEntryDate() {
        return RandomSource.dateTimeSource().randomFutureDate("yyyy-MM-dd");
    }

    private static String randomSentence(List<String> list) {
        return list.get((int) Math.floor(Math.random() * list.size()));
    }

    private static List<String> getArticleJSONList(String key) {
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader("resources/metadata/article.json"));
            String tempStr = null;
            while ((tempStr = reader.readLine()) != null) {
                sb.append(tempStr);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String jsonContent = sb.toString();
        JSONObject jsonObject = JSON.parseObject(jsonContent);
        JSONArray jsonArray = jsonObject.getJSONArray(key);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            list.add(jsonArray.getString(i));
        }
        return list;
    }

    public static String generateArticle(String title, Integer length) {
        if (length == null) {
            length = 800; // 默认生成 800 字文章
        }
        List<String> famousList = getArticleJSONList("famous");
        List<String> boshList = getArticleJSONList("bosh");
        List<String> beforeList = getArticleJSONList("before");
        List<String> afterList = getArticleJSONList("after");
        StringBuilder content = new StringBuilder();
        while (content.length() < length) {
            int num = (int) ((Math.random()) * 100);
            if (num < 10) {
                content.append("<br>");
            } else if (num < 20) {
                content.append(randomSentence(famousList)
                        .replace("a", randomSentence(beforeList))
                        .replace("b", randomSentence(afterList)));
            } else {
                content.append(randomSentence(boshList));
            }
        }
        return content.toString().replace("x", title);
    }

    public static void main(String[] args) {
        // for (int i = 0; i < 10; i++) {
        //     int gender = getNum(0, 1);
        //     String name = generateName(gender);
        //     String username = generateUsername(name);
        //     String phoneNum = generateTelephoneNum();
        //     String password = generatePassword();
        //     String email = RandomSource.internetSource().randomEmail(15);
        //     String enterpriseMail = generateEnterpriseMail(username);
        //     String IdCard = generateIdCard(gender);
        //     String degree = generateDegree();
        //     String college = generateCollege();
        //     String address = generateAddress();
        //     String entryDate = generateEntryDate();
        //     int status = 0;
        //     System.out.println(IdCard);
        // }
        String articles = generateArticle("幸福", 100);
        System.out.println(articles);
    }

}
