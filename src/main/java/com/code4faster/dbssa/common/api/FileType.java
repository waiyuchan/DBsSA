package com.code4faster.dbssa.common.api;

import java.util.Objects;

public enum FileType {

    JSON_FILE("json"),
    CSV_FILE("csv"),
    EXCEL_FILE("xlsx");

    private String fileType;

    FileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

}
