package com.example.demo.dao;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by lijiyang on 2017/7/31.
 */
public interface IUserDao extends JpaRepository<User,String>,JpaSpecificationExecutor<User>{
}
