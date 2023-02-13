package com.code4faster.dbssa.common.utils;

import com.code4faster.dbssa.mbg.model.MovieLib;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileProcessingUtils {
    public List<MovieLib> readCsvFile2ArrayList(String csvFilePath) {
        String line = "";
        String splitBy = ",";
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(csvFilePath));
            while ((line = bufferedReader.readLine()) != null) {
                String[] movieInstance = line.split(splitBy);
                StringBuilder style = new StringBuilder();
                MovieLib movieLib = new MovieLib();
                System.out.println(MovieLib.class);
                // for (int i = 0; i < movieInstance.length; ++i) {
                //     System.out.println(Integer.toString(i) + ": " + movieInstance[i].toString() + ": " + movieInstance[i].length());
                //     if (i < 7 || i > 9) {
                //
                //     } else {
                //         if (movieInstance[i].length() != 0)
                //             style.append(movieInstance[i]);
                //     }
                // }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        return null;
    }

    public boolean insertArrayList2MySQL(List<MovieLib> movieLibList) {
        return false;
    }

    public static void main(String[] args) {
        String movieFilepath = "dataset/movie.csv";
        FileProcessingUtils fileProcessingUtils = new FileProcessingUtils();
        List<MovieLib> movieLibList = fileProcessingUtils.readCsvFile2ArrayList(movieFilepath);
        // boolean isInserted = fileProcessingUtils.insertArrayList2MySQL(movieLibList);

    }
}
