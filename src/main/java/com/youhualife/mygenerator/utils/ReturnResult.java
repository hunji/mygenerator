package com.youhualife.mygenerator.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hunji
 * @version 1.0
 * @date 2020-11-17 15:16
 */
public class ReturnResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public ReturnResult() {
        put("code", 0);
    }

    public static ReturnResult error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static ReturnResult error(String msg) {
        return error(500, msg);
    }

    public static ReturnResult error(int code, String msg) {
        ReturnResult r = new ReturnResult();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static ReturnResult ok(String msg) {
        ReturnResult r = new ReturnResult();
        r.put("msg", msg);
        return r;
    }

    public static ReturnResult ok(Map<String, Object> map) {
        ReturnResult r = new ReturnResult();
        r.putAll(map);
        return r;
    }

    public static ReturnResult ok() {
        return new ReturnResult();
    }

    public ReturnResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
