package com.heitian.ssm.TestPackage;

import com.heitian.ssm.dao.CommentDao;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/24.
 */
public class GetTest {
    @Resource
    CommentDao dao;
    @Test
    void fuck(){
            String fuck="]阴、生津、润燥、活血]秘、痛经、虚劳喘咳、遗精者]尿病者";
            String[]shit=fuck.split("]");
        for (String ha:shit) {
            System.out.println(ha);
        }
    }
}
