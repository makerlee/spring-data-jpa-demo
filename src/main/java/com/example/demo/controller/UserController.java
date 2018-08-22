package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.jpa.HibernateHandler;
import com.example.demo.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Autowired
    private UserService userService;

    /**
     * 使用悲观锁实现并发访问的情况下，age可以正常++
     * @param id
     * @return
     */
    @RequestMapping(value = "/addAge",method = RequestMethod.POST)
    public String test(@RequestParam("id") String id){
        userService.addAge(id);
        return "success";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("account") String account,
                        @RequestParam("passwd") String passwd) {

        Map<String, Object> params = new HashMap<>();
        params.put("userName", account);
        params.put("loginPwd", passwd);
        List<User> result = this.hibernateHandler.getEntityListByPropertys(User.class, params);
        String response = "登录失败";
        if (result != null && result.size() > 0) {
            User user = result.get(0);
            //// TODO: 2017/7/31 返回用户信息
            ObjectMapper mapper = new ObjectMapper();
            try {
                response = mapper.writeValueAsString(user);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } else {
            //// TODO: 2017/7/31 登录失败
        }
        return response;
    }

    public static void main(String[] args) {
        System.out.println("0x28".getBytes());
        for (byte b:"0x28".getBytes()){
            System.out.println(b);
        }
    }

}
