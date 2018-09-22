package com.sys.gateway.service.impl;

import com.sys.gateway.dao.IUserDao;
import com.sys.gateway.service.IUserService;
import com.sys.gateway.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao iUserDao;

    @Override
    public List<User> queryUsers() {
        List<User> users = new ArrayList<>();
        users = iUserDao.queryUsers();
        return users;
    }
}
