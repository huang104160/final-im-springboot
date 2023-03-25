package com.test.im.controller;

import com.test.im.annotaion.LoginUser;
import com.test.im.pojo.Message;
import com.test.im.pojo.User;
import com.test.im.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/list")
    public Object list(@LoginUser User user, Long to, Integer pageNum, Integer pageSize) {
        return messageService.list(user, to, pageNum, pageSize);
    }

    @PostMapping("/add")
    public Object add(@LoginUser User user, @RequestBody Message message) {
        message.setFrom(user.getId());
        return messageService.add(message);
    }



}
