package com.ping.docservice.common;

import lombok.Data;

import java.io.Serializable;

/**
 * Generic Respond Wrapper Class
 * @param <T>: Class of Entity
 */

@Data
public class R<T>{

    private int code; // HTTP code
    private String msg;
    private T data;

    public static <T> R<T> success(T object){
        R<T> r = new R<>();
        r.code = 200;
        r.data = object;
        return r;
    }

    public static <T> R<T> error(int code, String msg){
        R<T> r = new R<>();
        r.code = code;
        r.msg = msg;
        return r;
    }
}
