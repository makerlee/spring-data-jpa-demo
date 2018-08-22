package com.example.demo.dao;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;

/**
 * Created by lijiyang on 2017/7/31.
 */
public interface IUserDao extends JpaRepository<User,String>,JpaSpecificationExecutor<User>{

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select user from User user where user.id=:id ")
    User findById(@Param("id")String id);



    User save(User user);
}
