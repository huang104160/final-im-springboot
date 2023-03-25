package com.test.im.controller;

import com.test.im.annotaion.LoginUser;
import com.test.im.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;
    @PutMapping("/updatePwd")
    public Object updateUserPwd(@LoginUser String uid, String oldPassword, String newPassword) {
        return userInfoService.updateUserPwd(uid, oldPassword, newPassword);
    }
}
