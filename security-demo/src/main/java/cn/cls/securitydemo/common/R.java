package cn.cls.securitydemo.common;

import cn.cls.securitydemo.constant.Constants;

import java.io.Serializable;

public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 成功
     */
    public static final int SUCCESS = Constants.SUCCESS;
    /**
     * 失败
     */
    public static final int FAIL = Constants.FAIL;
    private Integer code;
    private String msg;
    private T data;

    public static <T> R<T> ok() {
        return result(null, SUCCESS, null);
    }

    public static <T> R<T> ok(T data) {
        return result(data, SUCCESS, null);
    }

    public static <T> R<T> ok(T data, String msg) {
        return result(data, SUCCESS, msg);
    }

    public static <T> R<T> fail() {
        return result(null, FAIL, null);
    }

    public static <T> R<T> fail(String msg) {
        return result(null, FAIL, msg);
    }

    public static <T> R<T> fail(T data) {
        return result(data, FAIL, null);
    }

    public static <T> R<T> fail(T data, String msg) {
        return result(data, FAIL, msg);
    }

    public static <T> R<T> fail(Integer code, String msg) {
        return result(null, code, msg);
    }

    private static <T> R<T> result(T data, Integer code, String msg) {
        R<T> r = new R<>();
        r.setData(data);
        r.setCode(code);
        r.setMsg(msg);
        return r;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
