package com.code4faster.dbssa.common.api;

public class ApiResponse<T> {

    private long errorCode;
    private String errorMessage;
    private T data;

    protected ApiResponse() {
    }

    protected ApiResponse(long errorCode, String errorMessage, T data) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.data = data;
    }


    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<T>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), data);
    }

    public static <T> ApiResponse<T> failure(ErrorCode errorCode) {
        return new ApiResponse<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    // /**
    //  * 成功返回结果
    //  *
    //  * @param data    获取的数据
    //  * @param message 提示信息
    //  */
    // public static <T> Result<T> success(T data, String message) {
    //     return new Result<T>(ResultCode.SUCCESS.getCode(), message, data);
    // }
    //
    // /**
    //  * 失败返回结果
    //  *
    //  * @param errorCode 错误码
    //  */
    // public static <T> Result<T> failed(ErrorCode errorCode) {
    //     return new Result<T>(errorCode.getCode(), errorCode.getMessage(), null);
    // }
    //
    // /**
    //  * 失败返回结果
    //  *
    //  * @param message 提示信息
    //  */
    // public static <T> Result<T> failed(String message) {
    //     return new Result<T>(ResultCode.FAILED.getCode(), message, null);
    // }
    //
    // /**
    //  * 失败返回结果
    //  */
    // public static <T> Result<T> failed() {
    //     return failed(ResultCode.FAILED);
    // }
    //
    // /**
    //  * 参数验证失败返回结果
    //  */
    // public static <T> Result<T> validateFailed() {
    //     return failed(ResultCode.VALIDATE_FAILED);
    // }
    //
    // /**
    //  * 参数验证失败返回结果
    //  *
    //  * @param message 提示信息
    //  */
    // public static <T> Result<T> validateFailed(String message) {
    //     return new Result<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    // }
    //
    // /**
    //  * 未登录返回结果
    //  */
    // public static <T> Result<T> unauthorized(T data) {
    //     return new Result<T>(ResultCode.UNAUTHORIZED.getCode(),
    //             ResultCode.UNAUTHORIZED.getMessage(), data);
    // }
    //
    // /**
    //  * 未授权返回结果
    //  */
    // public static <T> Result<T> forbidden(T data) {
    //     return new Result<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(),
    //             data);
    // }


}

