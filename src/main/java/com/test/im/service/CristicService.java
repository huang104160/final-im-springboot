package com.test.im.service;

import com.test.im.dao.CristicDao;
import com.test.im.pojo.Comment;
import com.test.im.pojo.User;
import com.test.im.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CristicService {

    @Autowired
    CristicDao cristicDao;
    public Object comment(User user, Comment comment) {
        if(comment.getText().length()<=0){
            return ResponseUtils.fail(600,"请输入数据哦");
        }
//        Comment comment = new Comment(user.getId(), user.getUsername(), info);
        comment.setUid(user.getId());
        comment.setUsername(user.getUsername());
        cristicDao.insertText(comment);
        return ResponseUtils.ok();
    }
}
