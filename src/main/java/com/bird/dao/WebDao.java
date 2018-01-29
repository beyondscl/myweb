package com.bird.dao;

import com.bird.domain.Qzhapp;
import org.springframework.stereotype.Repository;

/**
 * author: 牛虻.
 * time:2018/1/27
 * email:pettygadfly@gmail.com
 * doc:
 */
@Repository
public interface WebDao {

    int registerUser(Qzhapp qzhapp);

    Qzhapp loginUser(Qzhapp qzhapp);

    int updateUser(Qzhapp qzhapp);

    int addGold(Qzhapp qzhapp);

    int setGold(Qzhapp qzhapp);
}
