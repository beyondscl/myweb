package com.bird.control;

import com.bird.domain.User;
import com.bird.service.UserService;
import org.junit.Assert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
public class UserCtl {
    private Logger logger = Logger.getLogger(UserCtl.class.getName());


    @Resource
    private UserService userService;

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

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(
            @RequestParam("name") String name,
            @RequestParam("password") String password,
            @ModelAttribute User user,
            HttpServletRequest request) {

        return "main";
    }

    @RequestMapping(value = "toLogin")
    public String toLogin() {
        return "login";
    }

}
