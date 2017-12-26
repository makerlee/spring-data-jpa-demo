package com.example.demo.services;

import com.example.demo.domain.User;

import java.util.List;

/**
 * Created by lijiyang on 2017/7/31.
 */
public interface UserService {
    List<User> getPage(String keyWords, int pageIndex, int pageSize);

    void addAge(String id);
}
