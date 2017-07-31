package com.example.demo.services.impl;

import com.example.demo.dao.IUserDao;
import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import com.example.demo.jpa.HibernateHandler;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
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
}
