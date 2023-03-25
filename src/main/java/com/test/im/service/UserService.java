package com.test.im.service;

import com.test.im.dao.UserDao;
import com.test.im.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;



    public Object getUserByUserName(String username) {

        return userDao.getUserByUserName(username);
    }

    public Object getUserByUserId(String userId) {
        User user = userDao.getUserByUserId(userId);
        if(user==null){
            return user;
        }
        // 这个部分先这样子
        user.setPassword("");
        return user;
    }

    public User getUserByUserIdHavePwd(String uid) {
        User user = userDao.getUserByUserId(uid);
        return user;
    }
}
