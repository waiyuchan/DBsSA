package com.code4faster.dbssa.common.utils;

import cn.hutool.extra.pinyin.PinyinUtil;
import com.apifan.common.random.RandomSource;
import com.apifan.common.random.constant.Province;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
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

    // 随机生成名字

    public static String generateName(int sex) {
        int choice = getNum(0, 1);
        return (choice == 0) ? generateEngName() : generateChnName(sex);
    }

    private static String generateEngName() {
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;
    }

    private static String generateChnName(int gender) {
        return (gender == 0) ? RandomSource.personInfoSource().randomMaleChineseName() : RandomSource.personInfoSource().randomFemaleChineseName();
    }

    public static boolean isChineseName(String name) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(name);
        return m.find();
    }

    public static String generateUsername(String name) {
        return (isChineseName(name)) ? PinyinUtil.getPinyin(name, "") : name.replace(" ", "_").toLowerCase();
    }

    public static int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }

    public static String generateIdCard(int gender) {
        LocalDate beginDate = LocalDate.of(1990, 11, 11);
        LocalDate endDate = LocalDate.of(1999, 12, 12);
        List<Province> provinceList = Arrays.asList(Province.values());
        int index = getNum(0, provinceList.size() - 1);
        return (gender == 0)
                ? RandomSource.personInfoSource().randomMaleIdCard(Province.valueOf(provinceList.get(index).toString()), beginDate, endDate)
                : RandomSource.personInfoSource().randomFemaleIdCard(Province.valueOf(provinceList.get(index).toString()), beginDate, endDate);
    }

    public static String generateTelephoneNum() {
        return RandomSource.personInfoSource().randomChineseMobile();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int gender = getNum(0, 1);
            String name = generateName(gender);
            String username = generateUsername(name);
            String phoneNum = generateTelephoneNum();
            String email = RandomSource.internetSource().randomEmail(15);
            String enterpriseEmail = username + "@code4faster.com";
            String IdCard = generateIdCard(gender);
            System.out.println(name + ", " + username + ", " + phoneNum + ", " + email + ", " + enterpriseEmail + ", " + IdCard);
        }
    }

}
