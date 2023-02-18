package com.code4faster.dbssa.common.api;

import java.util.UUID;

public class ApiResponse<T> {

    private long errorCode;
    private String errorMsg;
    private T data;
    private String requestId;

    protected ApiResponse() {
    }

    protected ApiResponse(long errorCode, String errorMsg, T data) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
        this.requestId = UUID.randomUUID().toString();
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<T>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), null);
    }


    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<T>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param message
     * @param data
     * @return
     */

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<T>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), data);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> ApiResponse<T> failure(ErrorCode errorCode) {
        return new ApiResponse<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> ApiResponse<T> unauthorized() {
        return new ApiResponse<T>(ErrorCode.UNAUTHORIZED_ACCESS.getCode(),
                ErrorCode.UNAUTHORIZED_ACCESS.getMessage(), null);
    }


    public long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(long errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getRequestId() {
        return requestId;
    }

}

