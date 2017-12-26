package com.example.demo.services.impl;

import com.example.demo.dao.IUserDao;
import com.example.demo.domain.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lijiyang on 2017/7/31.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> getPage(String keyWords, int pageIndex, int pageSize) {
        Specification<User> specification = Specifications.
                where((root, query, cb)->cb.equal(root.get("loginPwd"), keyWords));
        Pageable pageable = new PageRequest(pageIndex - 1, pageSize,Sort.Direction.ASC,"userName");


        Page<User> all = userDao.findAll(specification, pageable);
        return all.getContent();
    }

    @Transactional
    @Override
    public void addAge(String id) {
        User user = userDao.findById(id);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        user.setAge(user.getAge() + 1);
        userDao.save(user);
    }
}
