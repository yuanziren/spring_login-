package com.yuanziren.controller;

import com.yuanziren.model.ResultInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserControllerTest {

    @Test
    public void login() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserController userController = context.getBean("userController", UserController.class);

        ResultInfo info = userController.login("ZHILING", "123456");
        System.out.println(info);
    }

    @Test
    public void test01() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserController userController = context.getBean("userController", UserController.class);
        UserController userController2 = context.getBean("userController", UserController.class);

        System.out.println(userController);
        System.out.println(userController2);

        // 自带验证
        System.out.println(context.isSingleton("userController"));
    }

    @Test
    public void test02() throws Exception {
        new ClassPathXmlApplicationContext("spring.xml");
    }

    @Test
    public void test03() throws Exception {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        context.close();
    }
}