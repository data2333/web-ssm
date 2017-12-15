package com.heitian.ssm.dao;

import com.heitian.ssm.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */


public interface UserDao {
    Boolean addUserWithPhone(@Param("PhoneNum")String Phone,@Param("UserPwd")String user_pwd,@Param("UserName")String user_name);
    String isAUserPhoneExits(@Param("PhoneNum")String Phone);
    String isUserNameExits(@Param("user_name")String user_name);
    String UserLogin(@Param("PhoneNum")String Phone,@Param("UserPwd")String user_pwd);
    Boolean addCollection(@Param("user_id")String user_id,@Param("post_id")String post_id);
    void addNumPraises(@Param("post_id")Integer post_id);
    Boolean addPraises(@Param("user_id")Integer user_id,@Param("post_id")Integer post_id);
    User isUserHasPraise(@Param("user_id")Integer user_id,@Param("post_id")Integer post_id);
    String checkUserLoginOn(@Param("user_phone")String user_phone,@Param("user_pwd")String user_pwd);
    User getUserMessage(String user_phone);
}
