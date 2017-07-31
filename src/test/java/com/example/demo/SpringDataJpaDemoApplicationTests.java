package com.example.demo;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import com.example.demo.jpa.HibernateHandler;
import com.example.demo.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataJpaDemoApplicationTests {
	@Autowired
	private UserService userService;

	@Autowired
	private HibernateHandler hibernateHandler;

	@Test
	public void findPages() {
        List<User> users = userService.getPage("456", 2, 10);
        System.out.println("----------------->total= "+users.size());
        for(User u:users){
            System.out.println(u);
        }
    }

	@Test
	public void insert(){
		for(int i=0;i<15;i++){
			User u = new User();
			u.setUserName("jack"+i+i);
			u.setLoginPwd("456");
			hibernateHandler.addEntity(u);
		}
	}
}
