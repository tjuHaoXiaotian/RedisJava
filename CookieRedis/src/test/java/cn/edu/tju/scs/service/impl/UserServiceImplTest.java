package cn.edu.tju.scs.service.impl;

import cn.edu.tju.scs.entity.User;
import cn.edu.tju.scs.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    public void testLogin() throws Exception {
        User user = new User();
        user.setUsername("root");
        user.setPassword("root");
        System.out.println(userService.login(user));
    }

    @Test
    public void testLogout() throws Exception {
        String token = "eb049129b5574183972e7cf85f69bab0";
        System.out.println(userService.logout(token));
    }

    @Test
    public void testGetUserFromRedis() throws Exception {
        String token = "eb049129b5574183972e7cf85f69bab0";
        User user = userService.getUserFromRedis(token);
    }
}