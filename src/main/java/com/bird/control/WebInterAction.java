package com.bird.control;

import com.bird.domain.Qzhapp;
import com.bird.domain.User;
import com.bird.service.WebInter;
import com.bird.util.MathUtil;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import java.util.UUID;

/**
 * author: 牛虻.
 * time:2018/1/27
 * email:pettygadfly@gmail.com
 * doc:
 */
@Controller
@RequestMapping("/webinter/*")
public class WebInterAction {

    @Autowired
    private WebInter webInter;

    private String[] names = {"慕容", "慕容", "西门吹雪", "前锋", "段雪残桥"
            , "天下无敌", "慕容致富", "山村", "松下", "剑圣", "小小"
    };


    /**
     * 提供外部接口直接返回数据，类似servlet write
     * 用于游客登录或者注册
     *
     * @return
     */
    @RequestMapping(value = "registerUser", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String registerUser(String name, String password, String uuid) {
        Qzhapp qzhapp = new Qzhapp();
        qzhapp.setId(UUID.randomUUID().toString());
        qzhapp.setUuid(uuid);
        if (null == name || "".equals(name)) {
            name = names[MathUtil.getRom()];
        }
        qzhapp.setName(name);
        qzhapp.setPassword(password);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "-1");
        try {
            Qzhapp qzhapp1 = webInter.loginUser(qzhapp);
            if (null == qzhapp1) {//没有直接注册
                webInter.registerUser(qzhapp);
                jsonObject.put("code", "0");
                JSONObject data = new JSONObject();
                data.put("name", name);
                data.put("password", password);
                data.put("uuid", uuid);
                data.put("gold", "0");
                jsonObject.put("data", data);
            } else {//有再次注册，直接返回
                webInter.updateUser(qzhapp);
                jsonObject.put("code", "0");
                JSONObject data = new JSONObject();
                data.put("name", qzhapp1.getName());
                data.put("password", qzhapp1.getPassword());
                data.put("uuid", qzhapp1.getUuid());
                data.put("gold", "" + qzhapp1.getGold());
                jsonObject.put("data", data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "loginUser", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String loginUser(String name, String password, String uuid) {
        Qzhapp qzhapp = new Qzhapp();
        qzhapp.setId(UUID.randomUUID().toString());
        qzhapp.setUuid(uuid);
        qzhapp.setName(name);
        qzhapp.setPassword(password);


        JSONObject jsonObject = new JSONObject();
        Qzhapp qzhapp1 = webInter.loginUser(qzhapp);
        if (qzhapp1 == null) {
            jsonObject.put("code", "-1");
        } else {
            jsonObject.put("code", "0");
            JSONObject data = new JSONObject();
            data.put("name", name);
            data.put("password", password);
            data.put("uuid", uuid);
            data.put("gold", ""+qzhapp1.getGold());
            jsonObject.put("data", data);
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "addGold", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String addGold(String uuid, String gold) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "0");
        try {
            Qzhapp qzhapp = new Qzhapp();
            qzhapp.setUuid(uuid);
            qzhapp.setGold(Integer.valueOf(gold));
            webInter.addGold(qzhapp);
            Qzhapp qzhapp1 = webInter.loginUser(qzhapp);
            JSONObject data = new JSONObject();
            data.put("uuid", uuid);
            data.put("gold", ""+qzhapp1.getGold());
            jsonObject.put("data", data);
            return jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        jsonObject.put("code", "-1");
        return jsonObject.toString();
    }

    @RequestMapping(value = "setGold", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String setGold(String uuid, String gold) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "0");

        try {
            Qzhapp qzhapp = new Qzhapp();
            qzhapp.setUuid(uuid);
            qzhapp.setGold(Integer.valueOf(gold));
            webInter.setGold(qzhapp);
            qzhapp = webInter.loginUser(qzhapp);

            JSONObject data = new JSONObject();
            data.put("uuid", uuid);
            data.put("gold", ""+qzhapp.getGold());
            jsonObject.put("data", data);
            return jsonObject.toString();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        jsonObject.put("code", "-1");
        return jsonObject.toString();
    }


}
