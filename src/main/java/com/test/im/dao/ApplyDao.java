package com.test.im.dao;

import com.test.im.pojo.Apply;
import com.test.im.pojo.User;

import java.util.List;

public interface ApplyDao {

    Apply query(Apply apply);

    int add(Apply apply);

    List<User> getFriends(Long id);

    int deleteApply(Apply apply);
}
