package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.CommentDao;
import com.heitian.ssm.service.TimeService;
import com.heitian.ssm.util.TimeHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/27.
 */
@Service
public class Experiment implements TimeService {
    @Resource
    CommentDao dao;

    public void addTime() {
        Date date = new Date();//获得系统时间.
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        Timestamp time = Timestamp.valueOf(nowTime);
        dao.addTime(time);
    }

    public String getTime() {
        String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dao.getTime(2));
        TimeHandler obj=new TimeHandler();
        return  obj.getTime(time);
    }
}
