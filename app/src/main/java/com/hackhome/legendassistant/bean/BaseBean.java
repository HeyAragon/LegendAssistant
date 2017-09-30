package com.hackhome.legendassistant.bean;

/**
 * Created by Administrator on 2017/9/19 0019.
 */
public class BaseBean<T>{

    public static final int SUCCESS = 100;

    public int code;

    public String message;

    public T result;

    public boolean success() {
        return (code == SUCCESS);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
