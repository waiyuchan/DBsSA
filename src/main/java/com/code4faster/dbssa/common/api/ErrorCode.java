package com.code4faster.dbssa.common.api;

public enum ErrorCode {

    SUCCESS(0, "操作成功"),
    // 系统性错误
    UNKNOWN_ERROR(9999, "未知错误"),

    // 参数错误
    INVALID_PARAM(1001, "无效的参数"),

    // 用户错误
    USER_ALREADY_EXISTS(10001, "用户已存在");

    private final long code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}