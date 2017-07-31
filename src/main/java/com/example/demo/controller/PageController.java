package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.jpa.HibernateHandler;
import com.example.demo.pojo.Response;
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
public class PageController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "page",method = RequestMethod.POST)
    public Response<User> getUsers(@RequestParam("q") String keyWords,
                                   @RequestParam("pageIndex")int pageIndex,
                                   @RequestParam("pageSize") int pageSize){

        userService.getPage(keyWords,pageIndex,pageSize);
        return null;
    }
}
