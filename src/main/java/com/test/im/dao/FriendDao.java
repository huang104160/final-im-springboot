package com.test.im.dao;

import com.test.im.pojo.Friend;
import com.test.im.pojo.User;

import java.util.List;

public interface FriendDao {
    List<User> list(Long id);

    int add(Friend friend);
}
