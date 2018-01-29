package com.bird.service;

import com.bird.domain.Qzhapp;
import org.springframework.stereotype.Service;

/**
 * author: 牛虻.
 * time:2018/1/27
 * email:pettygadfly@gmail.com
 * doc:
 */
@Service
public interface WebInter {
    boolean registerUser(Qzhapp qzhapp);

    Qzhapp loginUser(Qzhapp qzhapp);

    boolean updateUser(Qzhapp qzhapp);

    boolean addGold(Qzhapp qzhapp);

    boolean setGold(Qzhapp qzhapp);
}
