package com.test.im.controller;

import com.test.im.annotaion.LoginUser;
import com.test.im.pojo.Apply;
import com.test.im.pojo.Comment;
import com.test.im.pojo.User;
import com.test.im.service.CristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/return")
public class CristicController {

    @Autowired
    CristicService cristicService;
    @PostMapping("/cristic")
    public Object cristic(@LoginUser User user, @RequestBody Comment comment){
        return cristicService.comment(user,comment);
    }

}
