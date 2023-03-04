package com.code4faster.dbssa.common.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileProcessingUtils {

    /**
     * CSV文件读取方法
     *
     * @param csvFilePath csv文件路径
     * @return 解析后的缓冲字符输入流
     */
    public BufferedReader csvFileReader(String csvFilePath) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(csvFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }


}
