package com.code4faster.dbssa.common.utils;

import com.code4faster.dbssa.mbg.model.MovieLib;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class FileProcessingUtils {

    public BufferedReader csvFileReader(String csvFilePath) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(csvFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }

    public List<Map<String, Object>> convertMovieCsvData2ArrayList(BufferedReader bufferedReader) {
        List<Map<String, Object>> maps = new ArrayList<>();
        String line = "";
        String splitBy = ",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)"; // 正则版优化方案
        // String splitBy = ","; // 初始方案，会导致双引号中的逗号也被处理

        try {
            // 处理CSV文件中的表头作为键值对的 `key`，`id` 需要单独补上
            String key = null;
            key = bufferedReader.readLine();
            List<String> keyList = Arrays.stream(key.split(splitBy, -1)).filter(Objects::nonNull).filter(string -> !string.isEmpty()).collect(Collectors.toList());
            List<String> finalKeys = new ArrayList<>();
            for (int i = 0; i < keyList.size(); i++) {
                if (i == 0) {
                    finalKeys.add("id");
                    continue;
                }
                if (i == 7) {
                    finalKeys.add("style");
                    continue;
                }
                if (i < 7 || i > 9) {
                    finalKeys.add(keyList.get(i));
                }
            }

            // 处理 `value`，使之匹配实体类
            while ((line = bufferedReader.readLine()) != null) {
                Map<String, Object> map = new HashMap<>();
                List<String> values = Arrays.stream(line.split(splitBy)).collect(Collectors.toList());
                StringBuilder style = new StringBuilder();
                for (int j = 0; j < finalKeys.size(); j++) {
                    String value;
                    if (j < 7) {
                        value = values.get(j);
                    } else if (j == 7) {
                        value = style.append(values.get(j)).append(" ")
                                .append(values.get(j + 1)).append(" ")
                                .append(values.get(j + 2)).toString();
                    } else {
                        value = values.get(j + 2);
                    }
                    String finalKey = finalKeys.get(j);
                    List<String> checkList = Arrays.asList("duration", "id");
                    ArrayList<String> listOfTypeCast = new ArrayList<>(checkList);
                    if (listOfTypeCast.contains(finalKey) && !value.equals("")) {
                        map.put(finalKey, Integer.parseInt(value));
                    } else {
                        map.put(finalKey, value);
                    }
                }
                maps.add(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return maps;
    }

    public List<MovieLib> convertMovieArrayListModelList(List<Map<String, Object>> maps) {
        List<MovieLib> movieLibs = new ArrayList<>();
        EntityUtils entityUtils = new EntityUtils();
        for (Map<String, Object> map : maps) {
            MovieLib movieLib = entityUtils.convertMap2EntityClass(map, MovieLib.class);
            movieLibs.add(movieLib);
        }
        return movieLibs;
    }

    public boolean insertMovieArrayList2MySQL(List<MovieLib> movieLibs) {
        String sql = "INSERT INTO `dbssa`.`movie_lib`(`id`, `name`, `english_name`, `directors`, `writer`, `actors`, `rate`, `style`, `country`, `language`, `date`, `duration`, `introduction`, `douban_id`, `url`, `pic`, `create_time`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP);";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbssa", "root", "root");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);
            for (MovieLib movieLib : movieLibs) {
                stmt.setInt(1, movieLib.getId());
                stmt.setString(2, movieLib.getName());
                stmt.setString(3, movieLib.getEnglishName());
                stmt.setString(4, movieLib.getDirectors());
                stmt.setString(5, movieLib.getWriter());
                stmt.setString(6, movieLib.getActors());
                stmt.setString(7, movieLib.getRate());
                stmt.setString(8, movieLib.getStyle());
                stmt.setString(9, movieLib.getCountry());
                stmt.setString(10, movieLib.getLanguage());
                stmt.setString(11, movieLib.getDate());
                if (movieLib.getDuration() != null) {
                    stmt.setInt(12, movieLib.getDuration());
                } else {
                    stmt.setNull(12, Types.INTEGER);
                }
                stmt.setString(13, movieLib.getIntroduction());
                stmt.setString(14, movieLib.getDoubanId());
                stmt.setString(15, movieLib.getUrl());
                stmt.setString(16, movieLib.getPic());
                stmt.addBatch();
            }
            stmt.executeBatch();
            conn.commit();
            System.out.println("更新成功");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        String movieFilepath = "resources/metadata/movie.csv";
        FileProcessingUtils fileProcessingUtils = new FileProcessingUtils();
        BufferedReader bufferedReader = fileProcessingUtils.csvFileReader(movieFilepath);
        List<Map<String, Object>> movieHashMaps = fileProcessingUtils.convertMovieCsvData2ArrayList(bufferedReader);
        List<MovieLib> movieLibs = fileProcessingUtils.convertMovieArrayListModelList(movieHashMaps);
        boolean isInserted = fileProcessingUtils.insertMovieArrayList2MySQL(movieLibs);
        System.out.println(isInserted);
    }
}
