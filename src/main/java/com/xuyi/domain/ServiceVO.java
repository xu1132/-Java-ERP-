package com.xuyi.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xuyi
 * @date 2022/11/03 9:20
 * @description 后端返回的实体
 */
@Data
public class ServiceVO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;
    private T info;

    public ServiceVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ServiceVO(int code, String msg, T info) {
        this.code = code;
        this.msg = msg;
        this.info = info;
    }

}
