package com.bird.dao;

import com.bird.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: 牛虻.
 * time:2017/11/19 0019
 * email:pettygadfly@gmail.com
 * doc:
 */
@Repository
public interface UserDao {
     User getUser(User user);

     List<User> getAllUser();

     void addUser(User user);

    User getUserByAccount(User user);

}
