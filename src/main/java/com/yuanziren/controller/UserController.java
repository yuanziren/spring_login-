package com.yuanziren.controller;

import com.yuanziren.model.ResultInfo;
import com.yuanziren.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope("prototype")
@Lazy(true)
@Controller
public class UserController implements InitializingBean {

//    public UserController() {
//        System.out.println("UserController init ...");
//    }

    @Autowired
    private UserService userService;

    public ResultInfo login(String username, String password){
        return userService.login(username, password);
    }


    public void init(){
        System.out.println("UserController 初始化了...");
    }

    public void destory(){
        System.out.println("UserController 销毁了...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("UserController 初始化了222...");
    }
}
