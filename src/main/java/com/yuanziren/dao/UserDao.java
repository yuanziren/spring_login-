package com.yuanziren.dao;


import com.yuanziren.po.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    private final String USERNAME="ZHILING";
    private final String PASSWORD="123456";

    public User queryUserByName(String username){
        User user = null;
        if(username.equals(USERNAME)){
            user = new User();
            user.setUsername(USERNAME);
            user.setPassword(PASSWORD);
        }
        return user;
    }
}
