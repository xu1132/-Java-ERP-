package com.xuyi.service.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.xuyi.dao.LogDao;
import com.xuyi.dao.UserDao;
import com.xuyi.entity.Log;
import com.xuyi.entity.User;
import com.xuyi.service.LogService;
import com.xuyi.util.DateUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author xuyi
 * @date 2022/11/03 10:48
 * @description
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;
    @Autowired
    private UserDao userDao;

    @Override
    public void save(Log log) {
        log.setLogDate(new Date());
        User user = userDao.findUserByName((String) SecurityUtils.getSubject().getPrincipal());
        log.setUserId(user.getUserId());
        logDao.save(log);
    }

    @Override
    public String list(String logType, String trueName, String sTime, String eTime, Integer page, Integer rows) {
        JsonObject result = new JsonObject();

        JsonArray array = new JsonArray();

        try {
            // 测试
            System.err.println(eTime);
            System.err.println(DateUtil.StringToDate(eTime, "yyyy-MM-dd HH:mm:ss"));

            page = page == 0 ? 1 : page;
            int offSet = (page - 1) * rows;

            List<Log> logList = logDao.getLogList(logType, trueName, DateUtil.StringToDate(sTime, "yyyy-MM-dd HH:mm:ss"),
                    DateUtil.StringToDate(eTime, "yyyy-MM-dd HH:mm:ss"), offSet, rows);

            for(Log log : logList) {

                JsonObject obj = new JsonObject();

                obj.addProperty("logId", log.getLogId());

                obj.addProperty("logType", log.getLogType());

                obj.addProperty("trueName", logDao.getTrueNameByLogId(log.getLogId()));

                obj.addProperty("logDate", DateUtil.DateToString(log.getLogDate(), "yyyy-MM-dd HH:mm:ss"));

                obj.addProperty("content", log.getContent());

                array.add(obj);

            }

            Long total = logDao.getLogCount(logType, trueName, DateUtil.StringToDate(sTime, "yyyy-MM-dd HH:mm:ss"),
                    DateUtil.StringToDate(eTime, "yyyy-MM-dd HH:mm:ss"));

            result.add("rows", array);

            result.addProperty("total", total);


        } catch (ParseException e) {

            e.printStackTrace();
        }

        return result.toString();
    }
}
