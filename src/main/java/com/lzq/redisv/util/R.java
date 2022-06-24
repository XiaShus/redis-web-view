package com.lzq.redisv.util;



import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class R<T> implements Serializable {
    private static final long serialVersionUID = 1679552421651455773L;
    private String success;
    private String code;
    private T data;
    private String msg;
    private Map<String, Object> extra;


    public Map<String, Object> getExtra() {
        return extra;
    }

    public R<T> setExtra(Map<String, Object> extra) {
        this.extra = extra;
        return this;
    }


    public String getSuccess() {
        return success;
    }

    public R<T> setSuccess(String success) {
        this.success = success;
        return this;
    }

    public String getCode() {
        return code;
    }

    public R<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public R<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public R<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public R() {
    }

    public static <T> R<T> ok(ErrorCode ErrorCode) {
        return new R<T>().setMsg(ErrorCode.getMsg())
                .setCode(ErrorCode.getCode())
                .setSuccess("true");
    }


    public static <T> R<T> success(T data) {
        return new R<T>()
                .setMsg(ErrorCode.OK.getMsg())
                .setData(data)
                .setCode(ErrorCode.OK.getCode())
                .setSuccess("true");
    }

    public static <T> R<String> success() {
        return new R<String>()
                .setMsg(ErrorCode.OK.getMsg())
                .setData("你的请求非常完美，我说的！")
                .setCode(ErrorCode.OK.getCode())
                .setSuccess("true");
    }

    public static R failed(ErrorCode ErrorCode) {
        return new R()
                .setSuccess("false")
                .setCode(ErrorCode.getCode())
                .setMsg(ErrorCode.getMsg());
    }

    public static R failed(String code, String msg) {
        return new R()
                .setMsg(msg)
                .setCode(code)
                .setSuccess("false");
    }

    public R<T> addExtraIfTrue(boolean bool, String key, Object value) {
        if (bool) {
            addExtra(key, value);
        }
        return this;
    }

    public R<T> addExtra(String key, Object value) {
        extra = extra == null ? new HashMap<>(16) : extra;
        extra.put(key, value);
        return this;
    }
}
