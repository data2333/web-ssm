package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.CommentDao;
import com.heitian.ssm.dao.PostDao;
import com.heitian.ssm.dao.UserDao;
import com.heitian.ssm.model.*;
import com.heitian.ssm.service.UserService;
import com.heitian.ssm.util.GetHost;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao dao;
    @Resource
    private PostDao postDao;

    public void addPraise(Integer user_id, Integer post_id) {
        dao.addNumPraises(post_id);
        dao.addPraises(user_id, post_id);
    }

    public Boolean isUserHasPraise(Integer user_id, Integer post_id) {
        return dao.isUserHasPraise(user_id, post_id) != null;
    }

    private Message isUserExits(String user_name, String user_phone) {
        String phone = dao.isAUserPhoneExits(user_phone);
        String name = dao.isUserNameExits(user_name);
        Message message = new Message();
        message.setUser_name_exits(name != null);
        message.setUser_phone_exits(phone != null);
        return message;
    }

    public Message addUserWithPhone(String user_name, String user_pwd, String user_phone) {
        Message message = isUserExits(user_name, user_phone);
        if (!message.getUser_name_exits() && !message.getUser_phone_exits()) {
            dao.addUserWithPhone(user_phone, user_pwd, user_name);
            message.setAdd_user_success(true);
        } else
            message.setAdd_user_success(false);
        return message;
    }

    public Message checkLogin(String user_phone, String user_pwd) {
        Message message = new Message();
        if (dao.isAUserPhoneExits(user_phone) == null)
            message.setUser_phone_exits(false);
        if (dao.checkUserLoginOn(user_phone, user_pwd) != null) {
            message.setLogin_in_success(true);
            User user = dao.getUserMessage(user_phone);
            message.setUser_message(user);
        }
        return message;
    }
    public User getCollection(Integer user_id) {
        User user = new User();
        List<Integer> list = postDao.getPosts(user_id);
        for (Integer id : list) {
            user.setUser_collection(new ArrayList<Posts>());
            Posts posts = postDao.getPostsById(id);
            posts.setUrl(GetHost.url + "/user/getPosts/posts/" + posts.getId());
            user.getUser_collection().add(posts);
        }
        return user;
    }

}
