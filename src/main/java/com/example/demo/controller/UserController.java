package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.jpa.HibernateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lijiyang on 2017/7/31.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private HibernateHandler hibernateHandler;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("account") String account,
                        @RequestParam("passwd") String passwd){

        Map<String,Object> params = new HashMap<>();
        params.put("userName",account);
        params.put("loginPwd",passwd);
        List<User> result = this.hibernateHandler.getEntityListByPropertys(User.class,params);
        if(result != null || result.size()>0){
            User user = result.get(0);
            //// TODO: 2017/7/31 返回用户信息
        }else{
            //// TODO: 2017/7/31 登录失败 
        }
        return null;
    }
}
