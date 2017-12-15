package com.heitian.ssm.service;

import com.heitian.ssm.model.Message;
import com.heitian.ssm.model.User;

import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */
public interface UserService {
    void addPraise(Integer user_id, Integer post_id);
    Boolean isUserHasPraise(Integer user_id, Integer post_id);
    Message addUserWithPhone(String user_name, String user_pwd, String user_phone);
    Message checkLogin(String user_phone,String user_pwd);
    User getCollection(Integer user_id);
}
