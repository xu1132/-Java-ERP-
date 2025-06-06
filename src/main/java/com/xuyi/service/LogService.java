package com.xuyi.service;

import com.xuyi.entity.Log;

/**
 * @author xuyi
 * @date 2022/10/25 16:34
 * @description
 */
public interface LogService {

    /**
     * 保存日志
     * @param log 日志实体
     */
    void save(Log log);

    String list(String logType,String trueName,String sTime,String eTime,Integer page,Integer rows);
}
