package com.faon.entity;

/**
 *  后端要统一返回的数据结构,便于前端处理
 *  code : 服务器返回的状态码(主要给程序员看)。例如 : 200 : 请求成功。 500 : 服务器内部错误。
 * status : 0 或者 1 (用于给前端判断) 。 1 : 处理成功。 0 : 处理失败 。这里要和 code 做区分。status 是逻辑上的错误。
            例如用户想要删除某一个帖子,用户手滑,连续发了两个请求, 第一个请求成功, 服务器返回 code: 200 , status : 1 。
            第二个请求成功,但是帖子已经被删除了。因此返回 code : 200 , status : 0 ,msg: “帖子不存在”
 * msg : 服务器的错误信息 ,主要返回给用户看。
 * data : 服务器返回的数据
 * @param <T>
 */
public class Result<T> {
    private int code;
    private int status;
    private String msg;
    private  T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
