package com.chengli.managerhosts.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回结果基类类型
 *
 * @author ChengLi
 */
@Data
public class ResultRsp<T> implements Serializable {
    private static final long serialVersionUID = 4870109340757185501L;
    private Integer code = 200;

    private String message = "";

    private T data;

    public static <T> ResultRsp<T> ok() {
        ResultRsp<T> rsp = new ResultRsp<T>();
        rsp.setCode(200);
        rsp.setMessage("操作成功");
        return rsp;
    }

    public static <T> ResultRsp<T> fail(String message) {
        ResultRsp<T> rsp = new ResultRsp<T>();
        rsp.setCode(9999);
        rsp.setMessage(message);
        return rsp;
    }
}
