package com.sys.gateway.service.impl;

import com.sys.gateway.dao.IUserDao;
import com.sys.gateway.service.IUserService;
import com.sys.gateway.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao iUserDao;

    @Override
    public Map<String, String> login(User user) {
        Map<String, String> result = new HashMap<>();
        result.put("code", "200");
        result.put("message", "success");
        //验证输入
        if(StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword())){
            result.put("code", "500");
            result.put("message", "username or password is null!");
            return result;
        }
        List<User> userDb = iUserDao.queryByCondition(user);
        if(userDb == null || userDb.size()==0 || !user.getPassword().equals(userDb.get(0).getPassword())){
            result.put("code", "500");
            result.put("message", "username or password error!");
            return result;
        }

        //生成token和Session
        return result;
    }
}
