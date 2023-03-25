package com.test.im.service;

import com.test.im.dao.RegisterDao;
import com.test.im.dao.UserDao;
import com.test.im.pojo.User;
import com.test.im.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;

@Service
public class RegisterService {

    @Autowired
    UserDao userDao;

    @Autowired
    RegisterDao registerDao;

    @Value("${imageBaseUrl}")
    private String imageBaseUrl;
    public Object register(Map<String, String> map) {
        User user = userDao.getUserByUserName(map.get("username"));
        if (user != null && user.getUsername().equals(map.get("username"))) {
            return ResponseUtils.usernameExist();
        } else {
            if ((map.get("password")).equals(map.get("password2"))) {
                User userNew = new User();
//            userNew.setId();
                userNew.setUsername(map.get("username"));
                userNew.setPassword(map.get("password"));
                int x = new Random().nextInt();
                x = x>0 ? x:-x;
                String imageId = "head"+Integer.toString(x%10)+".jpg";
                userNew.setImage(imageBaseUrl+imageId);
                registerDao.register(userNew);
                return ResponseUtils.ok();
            }
            else{
                return ResponseUtils.userPasswordIsNotSame();
            }
        }
    }
}
