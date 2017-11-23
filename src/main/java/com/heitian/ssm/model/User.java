package com.heitian.ssm.model;

import java.util.Date;

/**
 * Created by Zhangxq on 2016/7/15.
 */
public class User {

    private Long id;
    private String userName;
    private String userPhone;
    private String userEmail;
    private String userPwd;
    private String pwdSalt;
    private Date createTime;
    private Date modifyTime;
    private Short isDelete;

}
