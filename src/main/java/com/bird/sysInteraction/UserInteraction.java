package com.bird.sysInteraction;

import com.bird.domain.User;
import com.bird.service.UserService;

import java.util.List;

/**
 * author: 牛虻.
 * time:2018/1/21 0021
 * email:pettygadfly@gmail.com
 * doc:
 * 外部实现接口，用户接口
 */
public class UserInteraction implements BaseInteraction, UserService {
    public User getUser(User user) {
        return null;
    }

    public List<User> getAllUser() {
        return null;
    }

    public void test() {

    }

    public void addUser(User user) {

    }

    public User getUserByAccount(User user) {
        return null;
    }
}
