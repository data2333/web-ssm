package com.heitian.ssm.service.impl;

import com.heitian.ssm.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
//    @Resource
//    private UserDao userDao;
//
//    public User getUserById(Long userId) {
//        return userDao.selectUserById(userId);
//    }
//
//    public User getUserByPhoneOrEmail(String emailOrPhone, Short state) {
//        return userDao.selectUserByPhoneOrEmail(emailOrPhone,state);
//    }
//
//    public List<User> getAllUser() {
//        return userDao.selectAllUser();
//    }
//
//    public static void main(String[] args) {
//        UserServiceImpl userService=new UserServiceImpl();
//        Integer id=32;
//    }
}
