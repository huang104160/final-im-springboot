package com.test.im.controller;

import com.test.im.service.RegisterService;
import com.test.im.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @PostMapping
    public Object register(@RequestBody Map<String,String> map){
        if (CollectionUtils.isEmpty(map)){
            return ResponseUtils.badArgument();
        }
        return registerService.register(map);
    }

}
