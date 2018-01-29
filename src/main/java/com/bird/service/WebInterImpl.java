package com.bird.service;

import com.bird.dao.WebDao;
import com.bird.domain.Qzhapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author: 牛虻.
 * time:2018/1/27
 * email:pettygadfly@gmail.com
 * doc:
 */
@Service
public class WebInterImpl implements WebInter {

    @Resource
    private WebDao webDao;

    public boolean registerUser(Qzhapp qzhapp) {
        return 1 == webDao.registerUser(qzhapp);
    }

    public Qzhapp loginUser(Qzhapp qzhapp) {
        return webDao.loginUser(qzhapp);
    }

    public boolean updateUser(Qzhapp qzhapp) {

        return 1 == webDao.updateUser(qzhapp);
    }

    public boolean addGold(Qzhapp qzhapp) {
        return 1 == webDao.addGold(qzhapp);
    }

    public boolean setGold(Qzhapp qzhapp) {

        return 1 == webDao.setGold(qzhapp);
    }
}
