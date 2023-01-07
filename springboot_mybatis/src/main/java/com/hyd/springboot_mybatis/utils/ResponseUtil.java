package com.hyd.springboot_mybatis.utils;

import cn.hutool.core.util.ObjectUtil;

import java.util.HashMap;

/**
 * @Author: hayden
 * @Date: 2023-01-07
 * @Description: 请求响应
 */
public class ResponseUtil extends HashMap<String, Object>
{
    private static final long serialVersionUID = 1L;

    /** 状态码 */
    public static final String CODE_TAG = "code";

    /** 返回内容 */
    public static final String MSG_TAG = "msg";

    /** 数据对象 */
    public static final String DATA_TAG = "data";

    /**
     * 初始化一个新创建的 ResponseUtil 对象，使其表示一个空消息。
     */
    public ResponseUtil()
    {
    }

    /**
     * 初始化一个新创建的 ResponseUtil 对象
     *
     * @param code 状态码
     * @param msg 返回内容
     */
    public ResponseUtil(int code, String msg)
    {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 ResponseUtil 对象
     *
     * @param code 状态码
     * @param msg 返回内容
     * @param data 数据对象
     */
    public ResponseUtil(int code, String msg, Object data)
    {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (ObjectUtil.isNotNull(data))
        {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static ResponseUtil success()
    {
        return ResponseUtil.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static ResponseUtil success(Object data)
    {
        return ResponseUtil.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static ResponseUtil success(String msg)
    {
        return ResponseUtil.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static ResponseUtil success(String msg, Object data)
    {
        return new ResponseUtil(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static ResponseUtil error()
    {
        return ResponseUtil.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static ResponseUtil error(String msg)
    {
        return ResponseUtil.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static ResponseUtil error(String msg, Object data)
    {
        return new ResponseUtil(HttpStatus.ERROR, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg 返回内容
     * @return 警告消息
     */
    public static ResponseUtil error(int code, String msg)
    {
        return new ResponseUtil(code, msg, null);
    }

    /**
     * 方便链式调用
     *
     * @param key 键
     * @param value 值
     * @return 数据对象
     */
    @Override
    public ResponseUtil put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }
}
