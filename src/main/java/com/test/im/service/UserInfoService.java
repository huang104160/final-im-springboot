package com.test.im.service;


import com.test.im.dao.UserInfoDao;
import com.test.im.pojo.User;
import com.test.im.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    @Autowired
    UserService userService;

    public Object updateUserPwd(String uid, String oldPassword, String newPassword) {
        User userByUserId = userService.getUserByUserIdHavePwd(uid);
        if (userByUserId != null) {
            if (userByUserId.getPassword().equals(oldPassword)) {
                userInfoDao.updateUserPwd(uid, newPassword);
                return ResponseUtils.ok();
            } else {
                return ResponseUtils.fail(510, "密码修改失败，原密码错误");
            }

        } else {
            return ResponseUtils.fail(511, "未找到此用户。");
        }
    }
}
