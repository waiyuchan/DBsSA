package com.code4faster.dbssa.common.utils;

import com.code4faster.dbssa.common.api.FileType;

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

    /**
     * 获取文件的扩展名
     *
     * @param fileName 拓展名
     * @return 文件扩展名
     */
    public static String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex == -1) {
            return "";
        }
        return fileName.substring(lastDotIndex + 1);
    }

    /**
     * 根据文件后缀名检查是否与目标文件类型匹配
     *
     * @param fileExtension 文件后缀名
     * @param fileType 目标文件类型
     * @return True or False
     */
    public static boolean isFileTypeTrue(String fileExtension, FileType fileType) {
        return fileExtension.equals(fileType.getFileType());
    }


}
