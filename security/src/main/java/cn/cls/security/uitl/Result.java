package cn.cls.security.uitl;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private T data;
    private Integer code;
    private String msg;

    public Result(T data) {
        this.data = data;
    }

    public Result(T data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public Result(T data, Integer code) {
        this.data = data;
        this.code = code;
    }

    public Result(T data, Integer code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
