package com.yuanziren.service;


import com.yuanziren.dao.UserDao;
import com.yuanziren.model.ResultInfo;
import com.yuanziren.po.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public ResultInfo login(String username, String password){
        /***
         * 1. 参数校验(非空)
         * 2. 查询用户
         * 3. 验证密码是否正确
         * */
        ResultInfo info = new ResultInfo();

        if(username==null || username.equals("")){
            info.setCode(300);
            info.setMsg("用户名为空");
            return info;
        }
        if(password==null || password.equals("")){
            info.setCode(300);
            info.setMsg("密码为空");
            return info;
        }

        User user = userDao.queryUserByName(username);
        if(null==user){
            info.setCode(300);
            info.setMsg("用户不存在");
            return info;
        }else{
            if(password.equals(user.getPassword())){
                info.setCode(200);
                info.setMsg("登陆成功");
                return info;
            }else{
                info.setCode(300);
                info.setMsg("密码错误");
                return info;
            }
        }
    }

}
