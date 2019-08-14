package com.faon.util;

import com.faon.entity.Result;

public class ResultUtil {
    public static <T> Result<T> httpSuccess(T data) {
        return commonResult(1, 200, "请求成功", data);
    }

    public static <T> Result<T> httpError(String errorMsg) {
        return httpError(200, errorMsg);
    }

    public static <T> Result<T> httpError(Integer code, String errorMsg) {
        return commonResult(-1, code, errorMsg, null);
    }

    private static <T> Result<T> commonResult(Integer status, Integer code, String errMsg, T data) {
        Result<T> result = new Result<>();
        result.setStatus(status);
        result.setCode(code);
        result.setMsg(errMsg);
        result.setData(data);
        return result;
    }

}
