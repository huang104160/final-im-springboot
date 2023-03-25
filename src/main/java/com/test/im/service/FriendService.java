package com.test.im.service;

import com.test.im.dao.ApplyDao;
import com.test.im.dao.FriendDao;
import com.test.im.pojo.Apply;
import com.test.im.pojo.Friend;
import com.test.im.pojo.User;
import com.test.im.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    @Autowired
    private FriendDao friendDao;
    @Autowired
    private ApplyDao applyDao;

    public Object list(User user) {
       List<User> list =  friendDao.list(user.getId());
       return ResponseUtils.ok(list);
    }


    public Object add(Apply apply) {
        List<User> list = friendDao.list(apply.getUid());
        for (User user : list) {
            if((apply.getTid()).equals(user.getId()))
                return ResponseUtils.fail(1000,"对方已经是你的好友了，请勿重复添加");
        }
        Apply query = applyDao.query(apply);
        if(query!=null){
            return ResponseUtils.fail(999,"请求已经发送,请勿多次添加");
        }
        applyDao.add(apply);
        return ResponseUtils.ok1("添加好友请求发送成功！请等待对方确认。");
}

    public Object getFriends(User user) {
       List<User> list =  applyDao.getFriends(user.getId());
       return ResponseUtils.ok(list);
    }


    public Object agree(Friend friend) {
        //给friend表添加两行
        friendDao.add(friend);
        Friend friend1 = new Friend();
        friend1.setUid(friend.getFid());
        friend1.setFid(friend.getUid());
        friendDao.add(friend1);
        //从apply表删除
        Apply apply = new Apply();
        apply.setUid(friend.getFid());
        apply.setTid(friend.getUid());
        applyDao.deleteApply(apply);
        return ResponseUtils.ok1("您已接受该请求。");
    }

    public Object reject(Friend friend) {
        Apply apply = new Apply();
        apply.setTid(friend.getUid());
        apply.setUid(friend.getFid());
        applyDao.deleteApply(apply);
        return ResponseUtils.ok1("您已拒绝该请求。");
    }
}
