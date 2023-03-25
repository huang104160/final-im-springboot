package com.test.im.controller;

import com.test.im.annotaion.LoginUser;
import com.test.im.pojo.User;
import com.test.im.service.UserService;
import com.test.im.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Object User(@LoginUser User user){
        return ResponseUtils.ok(user);
    }

    @GetMapping("/getUserByUserName")
    public Object getUserByUserName(@LoginUser String username){

        return ResponseUtils.ok(userService.getUserByUserName(username));
    }


    @GetMapping("/getUserByUserId")
    public Object getUserByUserId(@LoginUser @RequestParam("uid") String userId){
        return ResponseUtils.ok(userService.getUserByUserId(userId));
    }

}
