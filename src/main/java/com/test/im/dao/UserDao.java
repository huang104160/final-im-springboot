package com.test.im.dao;

import com.test.im.pojo.User;

public interface UserDao {

    User getUserByUserName(String username);


    User getUserByUserId(String userId);
}
