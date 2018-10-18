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
        return result;
    }
}
