package com.bird.control;

import com.bird.domain.User;
import com.bird.service.UserService;
import com.bird.util.Token;
import org.junit.Assert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * author: 牛虻.
 * time:2017/11/11
 * email:pettygadfly@gmail.com
 * doc:
 */
@Controller
@RequestMapping("/user/*")
public class UserAction {
    private Logger logger = Logger.getLogger(UserAction.class.getName());


    @Resource
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user,
                        HttpServletRequest request) {
//        user = userService.getUserByAccount(user);
        if (null == user)
            return "login";
        request.setAttribute("token", Token.getToken(user));
        return "main";

    }

    @RequestMapping(value = "toLogin")
    public String toLogin() {
        return "login";
    }


    /**
     * 提供外部接口直接返回数据，类似servlet write
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "apiTest")
    @ResponseBody
    public String apiTest(String name, String password) {
        return "login";
    }

    @RequestMapping("jumpToMain")
    public String jump(HttpServletRequest request,
                       HttpServletResponse response,
                       HttpSession session) {
        session.setAttribute("TJSESSIONID", UUID.randomUUID().hashCode());
        User iUesr = new User();
        iUesr.setId(UUID.randomUUID().toString());
        iUesr.setName("hello");
        iUesr.setAge(11);
        userService.addUser(iUesr);
        System.out.println("-------------------------");
        User user = new User();
        user.setId("1");
        User result = userService.getUser(user);
        User result2 = userService.getUser(user);
        User result3 = userService.getUser(user);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result2);
        Assert.assertNotNull(result3);
        System.out.println("-------------------------");
        Object o = userService.getAllUser();
        System.out.println("-------------------------");

        return "main";
    }

}
